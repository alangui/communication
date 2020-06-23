package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/23 22:17
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println(atomicIntegerArray.length());
        System.out.println(atomicIntegerArray.get(0));

        atomicIntegerArray.set(0,10);
        System.out.println(atomicIntegerArray.get(0));
    }
}
