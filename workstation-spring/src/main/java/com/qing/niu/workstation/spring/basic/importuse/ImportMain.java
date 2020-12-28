package com.qing.niu.workstation.spring.basic.importuse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ImportMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        System.out.println(context.containsBean("car"));
        System.out.println(context.containsBean("person"));
        System.out.println(context.containsBean("WithholdReqDTO"));
        System.out.println(context.containsBean("tlBeanDefinitionRegister"));
        System.out.println(context.containsBean("car111"));
    }
}
