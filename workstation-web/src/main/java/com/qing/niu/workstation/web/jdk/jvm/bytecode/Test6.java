package com.qing.niu.workstation.web.jdk.jvm.bytecode;

/**
 * <p>
 *     方法的静态分派
 *
 *     Grandpa g1 = new Father();
 *     以上代码，g1的静态类型是Grandpa, 而g1的实际类型(真正指向的类型)是father
 *     变量的静态类型是不会发生变化的，而实际类型则是可以发生变化的（多态的一种体现）
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/14 21:58
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test6 {

    //方法重载，是一种静态的行为
    //编译期就可以完全确定的

    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Test6 test6 = new Test6();

        test6.test(g1);
        test6.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}