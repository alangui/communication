package com.qing.niu.workstation.spring.springboot.servlet;

import com.qing.niu.workstation.spring.springboot.servlet.filter.AngleFilter;
import com.qing.niu.workstation.spring.springboot.servlet.handletypes.IGjk;
import com.qing.niu.workstation.spring.springboot.servlet.listener.AngleListener;
import com.qing.niu.workstation.spring.springboot.servlet.servlet.AngleServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 16:30
 * @ProjectName communication
 * @Version 1.0.0
 */
@HandlesTypes(value = {IGjk.class})
public class GjkServeltContainInitializer implements ServletContainerInitializer{

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        List<IGjk> list = new ArrayList<>();
        if (null != set){
            for (Class gjkClass : set){
                if (!gjkClass.isInterface() && !Modifier.isAbstract(gjkClass.getModifiers()) && IGjk.class.isAssignableFrom(gjkClass)){
                    try {
                        list.add((IGjk) gjkClass.newInstance());
                    } catch (InstantiationException | IllegalAccessException e) {
                        System.err.println(e);
                    }
                }
            }
            for (IGjk iGjk : list){
                iGjk.sayHello();
            }
            servletContext.addListener(AngleListener.class);

            ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("angleServlet",new AngleServlet());
            servletRegistration.addMapping("/angleServlet");

            FilterRegistration.Dynamic angleFilter = servletContext.addFilter("angleFilter", AngleFilter.class);
            angleFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
        }
    }
}
