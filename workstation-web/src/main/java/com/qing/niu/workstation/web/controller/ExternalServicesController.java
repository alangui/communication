package com.qing.niu.workstation.web.controller;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     对外服务
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/10/31
 */
@Slf4j
@Controller
public class ExternalServicesController {

    @RequestMapping(value = "/demo")
    public void httpServiceDemo(HttpServletRequest request, HttpServletResponse response){
        try {
            log.info("有请求进入");
            log.info("有请求进入... 请求方式:{}",request.getMethod());
            log.info("请求http的协议版本:{}",request.getProtocol());
            log.info("项目名称:{}",request.getContextPath());
            log.info("完整请求路径:{}",request.getRequestURI());
            log.info("获取请求参数:{}",request.getQueryString());
            log.info("获取对象:{}",request.getRemoteUser());
            Enumeration<String> enumeration =  request.getHeaderNames();
            log.info("获取请求头列表:");
            while (enumeration.hasMoreElements()){
                String header = enumeration.nextElement();
                log.info("{} = {}",header,request.getHeader(header));
            }
            Map<String, String[]> map = request.getParameterMap();
            Set<Map.Entry<String, String[]>> set = map.entrySet();
            log.info("获取body参数:{}",set.size());
            for (Map.Entry<String,String[]> entry : set){
                log.info("key:{},value:{}",entry.getKey(),entry.getValue());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            String tempStr = "";
            while ((tempStr = bufferedReader.readLine()) != null){
                stringBuilder.append(tempStr);
            }
            log.info("获取到流内容:{}",stringBuilder.toString());

            byte[] resBytes = "欢迎访问".getBytes("UTF-8");
            response.setHeader("Content-type","text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write("欢迎访问");
            response.getOutputStream().write(resBytes);
        } catch (Exception e) {
            try {
                log.error("系统内部出错:{}", Throwables.getStackTraceAsString(e));
                response.getWriter().write("系统内部出错,请联系管理员!");
            } catch (IOException e1) {
                log.error("获取Servlet返回流错误!");
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public String httpServiceStr(@RequestParam(required = false) Map<String,String> params){
        log.info("服务进入。。。");
        log.info("获取请求参数:{}",params);
        return "ERROR";
    }
}
