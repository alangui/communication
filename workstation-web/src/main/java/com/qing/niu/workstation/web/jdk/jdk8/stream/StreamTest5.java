package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/25 12:10
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","bb","ccc","dddd");
        List<String> newList = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        newList.forEach(System.out::println);
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5));
        listStream.map(theList -> theList.stream().map(item -> item * item)).forEach(result -> result.forEach(System.out::println));

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5));
        stream.flatMap(theList -> theList.stream()).map(integer -> integer * integer).forEach(System.out::println);

    }
}
