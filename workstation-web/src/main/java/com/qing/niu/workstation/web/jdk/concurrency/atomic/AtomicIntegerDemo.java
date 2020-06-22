package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/21 23:06
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AtomicIntegerDemo {

    private final static AtomicInteger value = new AtomicInteger();

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int x = 0;
            while(x < 500){
                int temp = value.getAndIncrement();
                set.add(temp);
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                x++;
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 0;
            while(x < 500){
                int temp = value.getAndIncrement();
                set.add(temp);
                System.out.println(Thread.currentThread().getName() + ":" + temp);
                x++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("总数：" + set.size());
    }
}
