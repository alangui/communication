package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/22 21:43
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AtomicBooleanDemo {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println(atomicBoolean.get());

        AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
        System.out.println(atomicBoolean1.getAndSet(false));
        System.out.println(atomicBoolean1.get());

    }
}
