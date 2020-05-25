package com.qing.niu.workstation.spring.basic.beanpostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/23 11:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestInstantiationAwareBeanPostProcessorImpl implements InstantiationAwareBeanPostProcessor{

    static {
        System.out.println("TestInstantiationAwareBeanPostProcessorImpl class initial");
    }

    public TestInstantiationAwareBeanPostProcessorImpl(){
        System.out.println("TestInstantiationAwareBeanPostProcessorImpl 实例化");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInstantiation beanName:" + beanName);
        Object object = null;
        if (!FactoryBean.class.isAssignableFrom(beanClass) && beanName.equals("withholdReqDTO")) {
            try {
                object = beanClass.newInstance();
            } catch (Exception e) {
            }
            return object;
        }
        return object;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("poostProcessAfterInstantiation beanName:" + beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }
}
