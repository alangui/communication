package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.function.Function;

/**
 * <p>
 *     函数式接口编程方法传递的是行为
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/12 22:34
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(test3.compute(2,value -> {return 5 + value;}));
        System.out.println(test3.compute(1,value -> 2 * value));

        System.out.println(test3.convert(10,value -> String.valueOf(value + "00")));
    }

    public int compute(int a, Function<Integer, Integer> function){
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }
}
