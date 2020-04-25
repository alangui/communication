package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/21 20:36
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,9);
        System.out.println(list.stream().map(i -> 2 * i).reduce(0,Integer::sum));
    }
}
