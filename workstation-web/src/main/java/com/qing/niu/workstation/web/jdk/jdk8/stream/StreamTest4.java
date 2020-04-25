package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/22 21:50
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest4 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A","B","C");
        String[] stringArray = stream.toArray(length -> new String[length]);
        Arrays.asList(stringArray).forEach(System.out::println);

        System.out.println("------------------------");
        Stream<String> stream1 = Stream.of("A","B","C");
        String[] strings = stream1.toArray(String[]::new);
        Arrays.asList(strings).forEach(System.out::println);

        System.out.println("-----------------------");
        Stream<String> stream2 = Stream.of("A","B","C");
        List<String> list = stream2.collect(Collectors.toList());
//        List<String> list = stream2.collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::println);

        System.out.println("-----------------------");
        Stream<String> stream3 = Stream.of("A","B","C");
        Set<String> set = stream3.collect(Collectors.toSet());
        set.forEach(System.out::println);

    }
}
