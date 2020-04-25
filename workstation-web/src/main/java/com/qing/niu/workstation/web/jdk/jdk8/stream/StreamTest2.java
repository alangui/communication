package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/21 20:31
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest2 {

    public static void main(String[] args) {
        IntStream.of(new int[]{1,3,5,7,9}).forEach(System.out::println);

        System.out.println("--------------------");
        IntStream.range(3,9).forEach(System.out::println);

        System.out.println("--------------------");
        IntStream.rangeClosed(3,9).forEach(System.out::println);

    }
}
