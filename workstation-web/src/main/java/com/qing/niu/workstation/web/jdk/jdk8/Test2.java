package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 *     1、Consumer函数式接口
 *     2、Function函数式接口
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/12 20:58
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test2 {

    public static void main(String[] args) {
        MyInterface2_1 myInterface2_1 = () -> {};
        MyInterface2_2 myInterface2_2 = () -> {};
        System.out.println(myInterface2_1.getClass().getInterfaces()[0]);
        System.out.println(myInterface2_2.getClass().getInterfaces()[0]);

        new Thread(() -> System.out.println("hi")).start();

        List<String> list = Arrays.asList("hello","world");
        list.forEach(item -> System.out.println(item.toUpperCase()));

        List<String> list1 = new ArrayList<>();
        list.forEach(item -> list1.add(item.toUpperCase()));
        list1.forEach(item -> System.out.println(item));

        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));

        Function<String,String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}

interface MyInterface2_1{

    void myMethod();
}

interface MyInterface2_2{

    void myMethod2();
}