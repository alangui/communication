package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/29 0:05
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","hello world");

//        list.stream().filter(item -> item.length() == 5).limit(1).forEach(System.out::println);

        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}
