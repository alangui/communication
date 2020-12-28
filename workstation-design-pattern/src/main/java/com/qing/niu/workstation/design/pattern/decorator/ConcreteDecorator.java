package com.qing.niu.workstation.design.pattern.decorator;

/**
 * <p>
 *     具体装饰角色
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    private void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
