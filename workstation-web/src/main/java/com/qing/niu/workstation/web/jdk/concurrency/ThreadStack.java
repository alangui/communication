package com.qing.niu.workstation.web.jdk.concurrency;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/8 22:25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadStack {

    public static void main(String[] args) {
        threadStack();
    }

    public static void threadStack(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() + ":" + e.getLineNumber())
                .ifPresent(System.out::println));
    }
}
