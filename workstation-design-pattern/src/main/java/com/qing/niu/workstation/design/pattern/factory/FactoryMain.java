package com.qing.niu.workstation.design.pattern.factory;

/**
 * <p>
 *     工厂生产的是接口对象（多态），屏蔽了具体的实现类
 *
 *     当你需要生产一个接口的不同实现类时，用工厂方法，不同的工厂实现类实例化同一个工厂接口，
 *     多态，接口对象的使用屏蔽了具体的实现类，这个工厂接口生产一个接口
 *
 *     当你需要生产多个接口（可能彼此有关联）的不同实现类时，用抽象工厂方法，不同的工厂类实例化同一个工厂接口，
 *     这个工厂生产多个接口对象，屏蔽了具体的实现类
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class FactoryMain {

    public static void main(String[] args) {
        Application applicationPa = new ConcreteProductA();
        Product productA = applicationPa.getProduct();
        productA.method();

        Application applicationPb = new ConcreteProductB();
        Product productB = applicationPb.getProduct();
        productB.method();
    }
}
