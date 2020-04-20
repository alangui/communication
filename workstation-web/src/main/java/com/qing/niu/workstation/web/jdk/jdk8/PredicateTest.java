package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.function.Predicate;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/14 23:22
 * @ProjectName communication
 * @Version 1.0.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello world"));
    }
}
