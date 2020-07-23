package com.qing.niu.workstation.web.jdk.concurrency.executors;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/5 17:41
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ExecutorsDemo1 {

    public static void main(String[] args) throws InterruptedException {
//        useCacheThreadPool();
//        useFixedSizePool();
        useSinglePool();
    }

    private static void useCacheThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

        executorService.execute(() -> System.out.println("====================="));
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

        IntStream.range(0,100).boxed().forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " [" + i + "] ");
        }));

        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
    }

    private static void useFixedSizePool(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());

        IntStream.range(0,10).forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("========" + i + "=========");
            } catch (InterruptedException e) {
            }
        }));

        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
    }

    private static void useSinglePool(){
        /**
         * 对ThreadPoolExecutor进行了包装, 该线程池对像类屏蔽了ThreadPoolExecutor方法
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        IntStream.range(0,10).forEach(i -> executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("========" + i + "=========");
            } catch (InterruptedException e) {
            }
        }));

        System.out.println(((ThreadPoolExecutor)executorService).getActiveCount());
    }
}
