package com.qing.niu.workstation.spring.aop.annotation1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/12
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.spring.aop.annotation1
 * @Version 1.0.0
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Calculate calculate = (Calculate) applicationContext.getBean("calculate");
        int result = calculate.div(1,0);
        System.out.println(result);
    }
}
