package com.qing.niu.workstation.spring.beanpostprocessor;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/13 23:20
 * @ProjectName communication
 * @Version 1.0.0
 */
public class VolatileEvent extends ApplicationEvent{

    private String physicsAddress;

    public VolatileEvent(Object source, String physicsAddress){
        super(source);
        this.physicsAddress = physicsAddress;
    }

    public String getPhysicsAddress(){
        return physicsAddress;
    }
}
