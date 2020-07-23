package com.qing.niu.workstation.spring.aop.xml;

import org.springframework.aop.framework.Advised;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 19:49
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/spring-aop.xml");

        XmlActionDemo xmlActionDemo = (XmlActionDemo) applicationContext.getBean("xmlActionDemo");
        xmlActionDemo.placeOrder();
        xmlActionDemo.realTimePay();
        System.out.println(xmlActionDemo.getClass().getName());

        System.out.println("===================");
        xmlActionDemo.authAndPay();

        System.out.println("===================");
        xmlActionDemo.preOrder();

        System.out.println("===================");
        XmlActionDemo xmlActionDemo1 = (XmlActionDemo) ((Advised)xmlActionDemo).getTargetSource().getTarget();
        xmlActionDemo1.placeOrder();
        xmlActionDemo1.realTimePay();
        System.out.println(xmlActionDemo1);

        applicationContext.close();
    }
}
