package com.qing.niu.workstation.web.jdk.dynamicProxy;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/11 15:24
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestClass2 {

    public void method1() {
        System.out.println("the same method1");
    }

    public void method2() {
        System.out.println("the same method2");
    }

    public void method3() {
        System.out.println("the same method3");
    }

    @Override
    public String toString() {
        return "TestClass2{}";
    }
}
