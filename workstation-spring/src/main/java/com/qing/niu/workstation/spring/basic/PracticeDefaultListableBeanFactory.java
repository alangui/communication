package com.qing.niu.workstation.spring.basic;

import com.qing.niu.workstation.spring.model.WithholdReqDTO;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/30
 */
public class PracticeDefaultListableBeanFactory {

    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        System.out.println("numbers:" + defaultListableBeanFactory.getBeanDefinitionCount());
        String tradeNo = ((WithholdReqDTO)defaultListableBeanFactory.getBean("withholdReqDTO")).getTradeNo();
        System.out.println("tradeNo:" + tradeNo);
        System.out.println("bean classloader:" + defaultListableBeanFactory.getBeanClassLoader());
        System.out.println("singleton count:" + defaultListableBeanFactory.getSingletonCount());

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:beans.xml");
        System.out.println("numbers:" + applicationContext.getBeanDefinitionCount());
        System.out.println("tradeNo:" + ((WithholdReqDTO)applicationContext.getBean("withholdReqDTO")).getTradeNo());
    }
}
