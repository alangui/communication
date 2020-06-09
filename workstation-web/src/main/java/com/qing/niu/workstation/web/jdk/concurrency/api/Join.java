package com.qing.niu.workstation.web.jdk.concurrency.api;

import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/6 22:03
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Join {

    public static void main(String[] args) throws Exception{

        Thread t0 = new Thread(() -> IntStream.range(1,1000).
                forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i)));

        Thread t1 = new Thread(() -> IntStream.range(1,1000).
                forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i)));

//        t0.start();
//        t0.join();
//        System.out.println("haha");
//        t1.start();
//        t1.join();

        t0.start();
        t1.start();

        t0.join();
        System.out.println("haha");
        t1.join();

        System.out.println("all work have been finished");
    }
}
