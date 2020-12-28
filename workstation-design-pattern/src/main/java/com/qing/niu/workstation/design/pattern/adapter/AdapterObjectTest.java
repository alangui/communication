package com.qing.niu.workstation.design.pattern.adapter;

/**
 * <p>
 *     对象适配器模式
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AdapterObjectTest {

    public static void main(String[] args) {
        System.out.println("对象适配器模式测试");
        Adaptee adaptee = new Adaptee();
        Target target = new AdapterObject(adaptee);
        target.request();
    }
}
