package com.qing.niu.workstation.web.jdk.concurrency.api;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/7 17:38
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Synchronized {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            TestSynchronized.m1();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            TestSynchronized.m2();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            TestSynchronized.m3();
        }).start();
    }
}

class TestSynchronized{

    static {
        synchronized (TestSynchronized.class){
            System.out.println("static block");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized static void m1(){
        System.out.println("m1");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
        }
    }

    public synchronized static void m2(){
        System.out.println("m2");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
        }
    }

    public static void m3(){
        System.out.println("m3");
    }
}
