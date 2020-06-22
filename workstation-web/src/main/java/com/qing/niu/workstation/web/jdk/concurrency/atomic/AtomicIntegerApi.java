package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/21 23:36
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AtomicIntegerApi {

    private final static AtomicInteger value = new AtomicInteger(0);

    private static Thread lockedThread;

    public static void main(String[] args) {
        //create
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.get());
        atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.get());
        //set
        atomicInteger.set(12);
        System.out.println(atomicInteger.get());
        //get and set
        AtomicInteger atomicInteger1 = new AtomicInteger(10);
        System.out.println(atomicInteger1.getAndAdd(10));
        System.out.println(atomicInteger1.get());

    }

    public static boolean tryLock(){
        if (value.compareAndSet(0,1)){
            return true;
        }
        lockedThread = Thread.currentThread();
        return false;
    }

    public static void unLock(){
        if (value.get() == 0 || Thread.currentThread() != lockedThread){
            return;
        }
        value.compareAndSet(1,0);
    }

    private static void doSomething() throws InterruptedException {
        synchronized (AtomicIntegerApi.class){
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(100000);
        }
    }
}
