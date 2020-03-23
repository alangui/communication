package com.qing.niu.workstation.spring.basic;

import com.qing.niu.workstation.spring.beanpostprocessor.ApplicationContextAwareProcessorDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/13 18:52
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Annotation {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(ApplicationContextAwareProcessorDemo.class);
        System.out.println("spring init finish");
    }
}
