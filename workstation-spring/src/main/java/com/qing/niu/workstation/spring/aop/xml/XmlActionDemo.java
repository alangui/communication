package com.qing.niu.workstation.spring.aop.xml;

import org.springframework.aop.framework.AopContext;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 19:19
 * @ProjectName communication
 * @Version 1.0.0
 */
public class XmlActionDemo {

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

    // expose-proxy="true"
    public void preOrder(){
        System.out.println("pre place order");
        ((XmlActionDemo)AopContext.currentProxy()).placeOrder();
    }
}
