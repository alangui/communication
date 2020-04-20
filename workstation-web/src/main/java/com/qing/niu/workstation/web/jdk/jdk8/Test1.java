package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     1、lambda表达式格式 （param1,param2,...） -> {}
 *     2、如果只有一个参数，可以去掉（），如果只有一行代码，可以去掉{}
 *     3、在java语言中，lambda表达式本质是函数式接口的一个实例对象
 *       因此lambda必须依附于函数式接口
 *     4、函数式接口创建实例除了使用lambda表达式的方式，还可以使用方法引用、构造函数引用
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/12 17:17
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test1 {

    public void myTest(MyInterface myInterface){
        System.out.println("start");
        myInterface.test();
        System.out.println("end");
    }

    public static void main(String[] args) {
        List list = Arrays.asList("1","2","3");
        list.forEach(i -> System.out.println(i));

        Test1 test1 = new Test1();
        test1.myTest(() -> System.out.println("myTest"));

        list.forEach(System.out::println);

        System.out.println("-----------------------");

        MyInterface myInterface = () -> {
            System.out.println("666");
        };
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces().length);
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface MyInterface{

    void test();

    String toString();
}
