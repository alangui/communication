package com.qing.niu.workstation.spring.springboot.autoconfig.version2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 13:12
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("company"));
    }
}
