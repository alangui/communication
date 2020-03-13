package com.qing.niu.workstation.spring.springboot.autoconfig.version1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 13:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestBaseXml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-autoconfig.xml");
        System.out.println(context.getBean("company"));
    }
}
