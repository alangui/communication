package com.qing.niu.workstation.web.jdk.concurrency.executors;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/5 17:02
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadPoolExecutorTask {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10,20,30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), r -> {
            Thread thread = new Thread(r);
            return thread;
        },new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0,20).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println(Thread.currentThread().getName() + " [" + i + "] finish done.");
            } catch (InterruptedException e) {
            }
        }));

        /**
         * shutdown
         *
         * 20 threads
         *      10 threads work
         *      10 idle
         * shutdown invoked
         *      1、10 waiting to finish the work.
         *      2、10 interrupt idle thread
         *      3、20 idle thread will exist
         *
         */
//        executorService.shutdown();
//        executorService.awaitTermination(1,TimeUnit.HOURS);

        /**
         * shutdownNow
         *
         * 10 threads queue elements 10
         * 10 running
         * 10 stored in the blocking queue
         *
         * 1、return list remain 10 un handle runnable
         * 2、interrupt all of threads in the pool
         */
        List list = executorService.shutdownNow();
        System.out.println("size:" + list.size());
        System.out.println("====================over=====================");
    }
}
