package com.qing.niu.workstation.web.jdk.jdk8.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/17 21:49
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao","hello","world","welcome");
//        list.sort((a,b) -> b.length() - a.length());

//        list.sort(Comparator.comparingInt(String::length).reversed());

//        list.sort(Comparator.comparingInt(item -> item.length()));
//        Collections.sort(list,Comparator.comparingInt(item -> item.length()));
        list.sort(Comparator.comparingInt((String item) -> item.length()).reversed());
        System.out.println(list);
    }
}
