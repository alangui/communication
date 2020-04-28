package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/25 14:46
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","abc");
        list.stream().map(item -> item.substring(0,1).toUpperCase() + item.substring(1)).forEach(System.out::println);

        System.out.println("-------------------------");
        list.stream().map(item -> {
            String result = item.substring(0,1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        }).forEach(System.out::println);
    }
}
