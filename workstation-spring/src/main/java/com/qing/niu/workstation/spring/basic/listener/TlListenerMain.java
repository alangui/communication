package com.qing.niu.workstation.spring.basic.listener;

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
public class TlListenerMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TlListenConfig.class);
        context.publishEvent(new TlEvent("发布事件A"));
    }
}
