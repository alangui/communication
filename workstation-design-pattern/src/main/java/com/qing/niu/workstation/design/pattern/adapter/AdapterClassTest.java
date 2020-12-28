package com.qing.niu.workstation.design.pattern.adapter;

/**
 * <p>
 *     适配器模式（Adapter）通常适用于以下场景。
 *     1、以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
 *     2、使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。
 *
 *     类适配器模式
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AdapterClassTest {

    public static void main(String[] args) {
        System.out.println("类适配器模式测试");
        Target target = new AdapterClass();
        target.request();
    }
}
