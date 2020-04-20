package com.qing.niu.workstation.web.jdk.jvm.bytecode;

/**
 * <p>
 *     1、invokeinterface：调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的哪个对象的特定的方法
 *     2、invokestatic: 调用静态方法(静态解析)
 *     3、invokespecial: 调用自己的私有方法（无法被覆写）、构造方法以及父类的方法。（静态解析）
 *     4、invokevirtual: 调用虚方法，运行期动态查找的过程
 *     5、invokedynamic: 动态调用方法
 *
 *     静态解析在类加载阶段就可以将符号引用转换为直接引用
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/14 21:43
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test5 {

    public static void test(){
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
