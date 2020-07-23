package com.qing.niu.workstation.spring.aop.classic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/24 0:16
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/spring-aop-classic.xml");

        AcquiringService acquiringService = (AcquiringService) context.getBean("acquiringService");
        acquiringService.realTime();
        System.out.println(acquiringService.getClass().getName());

        AcquiringService acquiringService1 = (AcquiringService) context.getBean("proxy");
        acquiringService1.realTime();
        System.out.println(acquiringService1.getClass().getName());

        context.close();
    }
}
