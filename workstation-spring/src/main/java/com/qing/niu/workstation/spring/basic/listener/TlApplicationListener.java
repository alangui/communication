package com.qing.niu.workstation.spring.basic.listener;

import org.springframework.context.ApplicationListener;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TlApplicationListener implements ApplicationListener<TlEvent> {

    @Override
    public void onApplicationEvent(TlEvent event) {
        System.out.println("tlApplicationListener接受到一个事件:" + event.getSource());
    }
}
