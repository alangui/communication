package com.qing.niu.workstation.design.pattern.factory;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ConcreteProductB extends Application{

    @Override
    Product create() {
        return new ProductB();
    }
}
