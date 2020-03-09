package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 23:16
 * @ProjectName communication
 * @Version 1.0.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    public MyBeanPostProcessor(){
        super();
        System.out.println("这是BeanPostProcessor实现类构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("myBeanPostProcessor post process before Initialization:"+ beanName +"修改--->" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("myBeanPostProcessor post process after Initialization:"+ beanName +"修改--->" + bean);
        return bean;
    }
}
