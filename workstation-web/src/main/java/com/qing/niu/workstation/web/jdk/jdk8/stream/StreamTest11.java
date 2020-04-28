package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/29 0:20
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome","world hello","hello world hello","hello welcome");

        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).
                distinct().forEach(System.out::println);
    }
}
