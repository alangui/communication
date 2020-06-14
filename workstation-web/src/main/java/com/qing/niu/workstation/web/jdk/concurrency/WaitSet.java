package com.qing.niu.workstation.web.jdk.concurrency;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/11 23:17
 * @ProjectName communication
 * @Version 1.0.0
 */
public class WaitSet {

    private static final Object LOCK = new Object();

    private static void work(){
        synchronized (LOCK){
            System.out.println("Begin....");
            System.out.println("Thread will coming");
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("Thread will out.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> work()).start();
        Thread.sleep(1000);
        synchronized (LOCK) {
            LOCK.notify();
        }

        IntStream.rangeClosed(1,10).forEach(i -> {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    synchronized (LOCK){
                        Optional.of(Thread.currentThread().getName() + " will come to wait set").ifPresent(System.out::println);
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                        }
                        Optional.of(Thread.currentThread().getName() + " will leave to wait set").ifPresent(System.out::println);
                    }
                }
            }.start();
        });

        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
        }

        IntStream.rangeClosed(1,10).forEach(i -> {
            synchronized (LOCK){
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });
    }
}
