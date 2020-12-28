package com.qing.niu.workstation.design.pattern.decorator;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("=====================");
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
