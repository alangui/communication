package com.qing.niu.workstation.design.pattern.chainofresponsibility;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2021/1/5
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler1.handleRequest("two");
    }
}
