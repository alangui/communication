package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 23:51
 * @ProjectName communication
 * @Version 1.0.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    public MyBeanFactoryPostProcessor(){
        System.out.println("这是BeanFactoryPostProcessor实现类");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("对beanDefinition的处理:" + beanFactory.getBeanDefinitionCount());
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        System.out.println("beanDefinition:" + beanDefinition.getPropertyValues());
        beanDefinition.getPropertyValues().addPropertyValue("name","李四");
        System.out.println("beanDefinition:" + beanDefinition.getPropertyValues());

        BeanDefinition beanDefinition1 = beanFactory.getBeanDefinition("persion1");
        beanDefinition1.getPropertyValues().addPropertyValue("phone","15688888888");
    }
}
