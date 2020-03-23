package com.qing.niu.workstation.spring.beanpostprocessor;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/13 23:31
 * @ProjectName communication
 * @Version 1.0.0
 */
@Component
public class VolatileListen implements ApplicationListener<VolatileEvent>{

    @Override
    public void onApplicationEvent(VolatileEvent event) {
        System.out.println("地址：" + event.getPhysicsAddress() + "数据已失效");
    }
}
