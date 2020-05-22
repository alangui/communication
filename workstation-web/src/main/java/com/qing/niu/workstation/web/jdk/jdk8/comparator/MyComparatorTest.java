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
        //1
        list.sort((a,b) -> b.length() - a.length());
        //2
        list.sort(Comparator.comparingInt(String::length).reversed());
        //3
        list.sort(Comparator.comparingInt(item -> item.length()));
        //4
        Collections.sort(list,Comparator.comparingInt(item -> item.length()));
        //5
        list.sort(Comparator.comparingInt((String item) -> item.length()).reversed());
        //6
        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        //7
        list.sort(Comparator.comparingInt(String::length).
                thenComparing((item1,item2) -> item1.toLowerCase().compareTo(item2.toLowerCase())));
        //8
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(String::toLowerCase)));
        //9
        list.sort(Comparator.comparingInt(String::length).
                thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));
        //10
        list.sort(Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())).
                thenComparing(Comparator.reverseOrder()));
        System.out.println(list);
    }
}
