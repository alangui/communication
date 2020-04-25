package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/25 12:37
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest6 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::println);

        Stream.iterate(1,item -> item + 2).limit(10).forEach(System.out::println);

        System.out.println("---------------------------");
        //1,3,5,7,9,11 -> 3,5,7,9,11 -> 6,10,14,18,22 -> 14,18,22 -> 14,18 -> 32
        Stream.iterate(1,item -> item + 2).limit(6).
                filter(element -> element > 2).
                map(element -> element * 2).peek(System.out::println).
                skip(2).
                limit(2).
                collect(Collectors.reducing((i,j) -> i + j)).ifPresent(System.out::println);

        int sum = Stream.iterate(1,item -> item + 2).limit(6).
                filter(element -> element > 2).mapToInt(element -> element * 2).skip(2).limit(2).sum();
        System.out.println(sum);


    }
}
