package com.qing.niu.workstation.spring.basic;

import com.qing.niu.workstation.spring.FactoryBean.CarFactoryBean;
import com.qing.niu.workstation.spring.model.Car;
import com.qing.niu.workstation.spring.model.WithholdReqDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/1/18 14:43
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BeanFactoryAnalysis {

    public static void main(String[] args) throws Exception{
        DefaultListableBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        xmlBeanFactory.addBeanPostProcessor((InstantiationAwareBeanPostProcessor) xmlBeanFactory.getBean("testInstantiationAwareBeanPostProcessor"));
        WithholdReqDTO withholdReqDTO = (WithholdReqDTO) xmlBeanFactory.getBean("withholdReqDTO");
        System.out.println(withholdReqDTO.getTradeNo());

        Car car1 = (Car) xmlBeanFactory.getBean("car");
        Car car2 = (Car) xmlBeanFactory.getBean("car");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car1 == car2);

        CarFactoryBean carFactoryBean = (CarFactoryBean) xmlBeanFactory.getBean("&car");
        Car car3 = carFactoryBean.getObject();
        Car car4 = carFactoryBean.getObject();
        System.out.println(car3 == car4);

        System.out.println("=========循环依赖=========");
        System.out.println(xmlBeanFactory.getBean("testA"));
    }
}
