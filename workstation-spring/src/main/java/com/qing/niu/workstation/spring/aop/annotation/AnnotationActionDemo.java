package com.qing.niu.workstation.spring.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 9:52
 * @ProjectName communication
 * @Version 1.0.0
 */
@Service
public class AnnotationActionDemo {

    @Action(name = "traceLogId")
    public void placeOrder(){
        System.out.println("进入下单流程。。。");
        System.out.println("下单成功");
    }

    public boolean realTimePay(){
        System.out.println("支付完成");
        return true;
    }

    public void authAndPay(){
        System.out.println("授权完成");
        placeOrder();
        realTimePay();
    }
}
