package com.qing.niu.quartz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/3/10 16:40
 * @ProjectName communication
 * @Version 1.0.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
