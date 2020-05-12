package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/29 23:15
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi","Hello","你好");
        List<String> list2 = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");

        list1.stream().flatMap(item1 -> list2.stream().map(item2 -> item1 + " " + item2)).
                collect(Collectors.toList()).forEach(System.out::println);

    }
}
