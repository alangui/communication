package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <p>
 *     创建流的方式
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/21 20:26
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream stream = Stream.of("hello","world");

        String[] myArray = new String[]{"hello","world"};
        Stream stream1 = Stream.of(myArray);

        Stream stream2 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream stream3 = list.stream();
    }
}
