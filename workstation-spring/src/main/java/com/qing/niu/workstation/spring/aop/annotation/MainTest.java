package com.qing.niu.workstation.spring.aop.annotation;

import org.springframework.aop.framework.Advised;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 10:26
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AopConfig.class);
        annotationConfigApplicationContext.refresh();

        AnnotationActionDemo annotationActionDemo = (AnnotationActionDemo) annotationConfigApplicationContext.getBean("annotationActionDemo");
        System.out.println(annotationActionDemo.getClass().getName());
        annotationActionDemo.placeOrder();
        annotationActionDemo.realTimePay();

        System.out.println("===================================");
        annotationActionDemo.authAndPay();

        System.out.println("===================================");
        AnnotationActionDemo annotationActionDemo1 = (AnnotationActionDemo)((Advised)annotationActionDemo).getTargetSource().getTarget();
        System.out.println(annotationActionDemo1.getClass().getName());
        annotationActionDemo1.placeOrder();
        annotationActionDemo1.realTimePay();

        annotationConfigApplicationContext.close();
    }
}
