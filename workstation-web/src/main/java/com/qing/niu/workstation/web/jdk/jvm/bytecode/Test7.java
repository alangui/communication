package com.qing.niu.workstation.web.jdk.jvm.bytecode;

/**
 * <p>
 *     动态分派：方法接收者
 *
 *     invokevirtual指令的多态查找流程
 *     jvm在类的方法区建立一个虚方法表的数据结构
 *     针对于invokeinterface指令来说，
 *     jvm会建立一个叫做接口方法表的数据结构
 *
 *     方法重载是静态的，是编译期行为；方法重写是动态的，是运行期行为。
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/15 19:25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test7 {

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit{

    public void test(){
        System.out.println("Fruit");
    }
}

class Apple extends Fruit{
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit{
    @Override
    public void test() {
        System.out.println("Orange");
    }
}