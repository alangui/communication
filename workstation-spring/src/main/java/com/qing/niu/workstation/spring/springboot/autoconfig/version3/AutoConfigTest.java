package com.qing.niu.workstation.spring.springboot.autoconfig.version3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 14:13
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AutoConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ObjectAutoConfig.class);
        System.out.println(annotationConfigApplicationContext.getBean("company"));
    }
}
