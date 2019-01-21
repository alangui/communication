package com.qing.niu.java.concurrency.phaser;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/13 17:15
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Student implements Runnable {

    private Phaser phaser;

    public Student(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam. %s\n", Thread
                        .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the first exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        sleep();
        System.out.printf("%s: Has done the first exercise. %s\n", Thread
                        .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the second exercise.%s\n",
                Thread.currentThread().getName(), new Date());
        sleep();
        System.out.printf("%s: Has done the second exercise. %s\n", Thread
                        .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the third exercise. %s\n",
                Thread.currentThread().getName(), new Date());
        sleep();
        System.out.printf("%s: Has finished the exam. %s\n", Thread
                        .currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    public void sleep(){
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
