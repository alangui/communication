package com.qing.niu.workstation.spring.Lifecircle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/8 19:38
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("容器启动，开始初始化。。。");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("容器初始化完成");
        Persion1 persion1 = (Persion1) ctx.getBean("persion1");
        System.out.println(persion1);
        System.out.println("开始关闭容器。。。");
//        ctx.registerShutdownHook();
    }
}
