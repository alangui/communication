package com.qing.niu.workstation.springmvc.finishbyhand;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/12 19:13
 * @ProjectName communication
 * @Version 1.0.0
 */
public class HandlerServlet extends HttpServlet{

    private WebApplicationContext context;

    private MvcBeanFactory beanFactory;

    final ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    private Configuration freemarkerConfig;

    @Override
    public void init() throws ServletException {
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        beanFactory = new MvcBeanFactory(context);
        Configuration freemakerConfig = null;
        freemakerConfig = context.getBean(Configuration.class);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }

    public void doHandle(HttpServletRequest req, HttpServletResponse resp){
        String uri = req.getServletPath();
        if (uri.equals("/favicon.ico")){
            return;
        }
        MvcBeanFactory.MvcBean mvcBean = beanFactory.getMvcBean(uri);
        if (null == mvcBean){
            throw new IllegalArgumentException(String.format("not found %s mapping",uri));
        }

        Object[] args = buildParams(mvcBean,req,resp);

        try {
            Object result = mvcBean.run(args);
            processResult(result,resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void processResult(Object result, HttpServletResponse resp){
        if (result instanceof FreemarkerView){
            FreemarkerView freemarkerView = (FreemarkerView) result;
            Template temp = null;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            resp.setContentType("text/html; charset=utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setStatus(200);
        }
    }

    public Object[] buildParams(MvcBeanFactory.MvcBean mvcBean, HttpServletRequest req, HttpServletResponse resp){
        Method method = mvcBean.getTargetMethod();
        List<String> paramNames = Arrays.asList();
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < paramNames.size(); i++){
            if (paramTypes[i].isAssignableFrom(HttpServletRequest.class)){
                args[i] = req;
            } else if (paramTypes[i].isAssignableFrom(HttpServletResponse.class)){
                args[i] = resp;
            } else {
                if (req.getParameter(paramNames.get(i)) == null){
                    args[i] = null;
                } else {
                    args[i] = convert(req.getParameter(paramNames.get(i)),paramTypes[i]);
                }
            }
        }
        return args;
    }

    public <T> T convert(String val, Class<T> targetClass){
        Object result = null;
        if (null == val){
            return null;
        } else if (Integer.class.equals(targetClass)){
            result = Integer.parseInt(val.toString());
        } else if (Long.class.equals(targetClass)){
            result = Long.parseLong(val.toString());
        } else if (Date.class.equals(targetClass)){
            try {
                result = new SimpleDateFormat("").parse(val);
            } catch (ParseException e) {
                throw new IllegalArgumentException("date format Illegal must be 'yyyy-MM-dd HH:mm:ss'");
            }
        } else if (String.class.equals(targetClass)){
            result = val;
        } else {
            System.err.println(String.format("not support param type %s", targetClass.getName()));
        }
        return (T) result;
    }
}
