package com.qing.niu.workstation.spring.springboot.autoconfig.version1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 13:37
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MyBeanFactoryPost implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("employee");
        genericBeanDefinition.getPropertyValues().addPropertyValue("name","张小三");
        System.out.println("employee对象属性修改成功");
    }
}
