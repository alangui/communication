package com.qing.niu.workstation.web.jdk.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/1 21:37
 * @ProjectName communication
 * @Version 1.0.0
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                System.out.println("do some initial working.");
                try {
                    Thread.sleep(1000);
                    latch.await();
                    System.out.println("do other working...");
                } catch (InterruptedException e) {
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("asy prepare for some data");
                try {
                    Thread.sleep(2000);
                    System.out.println("data prepare for done.");
                } catch (InterruptedException e) {
                } finally {
                    latch.countDown();
                }
            }
        }.start();

        Thread.currentThread().join();
    }
}
