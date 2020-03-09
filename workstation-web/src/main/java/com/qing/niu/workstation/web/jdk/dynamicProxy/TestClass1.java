package com.qing.niu.workstation.web.jdk.dynamicProxy;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/11 15:22
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestClass1 implements TestInterface{

    @Override
    public void method1() {
        System.out.println("implement interface method1");
    }

    @Override
    public void method2() {
        System.out.println("implement interface method2");
    }

    @Override
    public void method3() {
        System.out.println("implement interface method3");
    }

    @Override
    public String toString() {
        return "TestClass1{}";
    }
}
