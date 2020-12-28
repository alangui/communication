package com.qing.niu.workstation.spring.basic.listener;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TlEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TlEvent(Object source) {
        super(source);
    }
}
