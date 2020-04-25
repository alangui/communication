package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/25 14:54
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest8 {

    public static void main(String[] args) {
        IntStream.iterate(0,i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
        IntStream.iterate(0,i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
    }
}
