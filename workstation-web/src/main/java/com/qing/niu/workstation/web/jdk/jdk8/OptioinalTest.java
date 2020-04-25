package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.Optional;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/18 9:37
 * @ProjectName communication
 * @Version 1.0.0
 */
public class OptioinalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("666");
        //不推荐的方式
        if (optional.isPresent()){
            System.out.println(optional.get());
        }
        //推荐的方式
        optional.ifPresent(item -> System.out.println(item));

        optional = Optional.empty();
        System.out.println("--------------------------");
        System.out.println(optional.orElse("777"));

        optional = Optional.ofNullable(null);
        System.out.println("--------------------------");
        System.out.println(optional.orElseGet(() -> "888"));

    }
}
