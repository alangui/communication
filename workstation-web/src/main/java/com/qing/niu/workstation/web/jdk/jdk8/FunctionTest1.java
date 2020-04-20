package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/13 23:07
 * @ProjectName communication
 * @Version 1.0.0
 */
public class FunctionTest1 {

    public static void main(String[] args) {
        FunctionTest1 test1 = new FunctionTest1();
        System.out.println(test1.compute1(2,value -> value * 3,value -> value*value));//12
        System.out.println(test1.compute2(2,value -> value * 3,value -> value*value));//36

        System.out.println(test1.compute3(1,2,(value1,value2) -> value1 + value2));
        System.out.println(test1.compute3(1,2,(value1,value2) -> value1 - value2));
        System.out.println(test1.compute3(1,2,(value1,value2) -> value1 * value2));
        System.out.println(test1.compute3(1,2,(value1,value2) -> value1 / value2));

        System.out.println(test1.compute4(2,3,(value1,value2) -> value1 + value2,value -> value * value));
    }

    public int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(a,b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        return biFunction.andThen(function).apply(a,b);
    }
}
