package com.qing.niu.workstation.web.jdk.concurrency.ThreadExceptionCaught;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/5 14:03
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ThreadMonitor {

    private final static Logger logger = LoggerFactory.getLogger(ThreadMonitor.class);

    private volatile boolean inited = false;

    private static int threadIndex = 0;

    private BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

    public synchronized void init(){
        if (inited){
            return;
        }
        logger.info("thread monitor init...");
        WorkerThread workerThread = new WorkerThread();
        workerThread.setName("worker0-" + threadIndex++);
        workerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.info("抛出异常线程为:{},线程状态:{}",t.getName(),t.isAlive());

                logger.info("抛出错误:{}",e.toString());

                logger.info("restart thread monitor");

                inited = false;

                init();
            }
        });
        workerThread.start();
        inited = true;
    }

    public void service(String task) throws InterruptedException {
        queue.put(task);
    }

    private class WorkerThread extends Thread{

        @Override
        public void run() {
            logger.info("work thread doing something");
            String work;
            try {
                for (;;){
                    work = queue.take();
                    process(work);
                }
            } catch (InterruptedException e) {
                logger.warn("occur interrupted exception");
            }
        }

        private void process(String work) throws InterruptedException {
            String name = Thread.currentThread().getName();
            int random = (int)(Math.random() * 100);
            logger.info("{}正在处理任务。。。{}",name,random);
            if (random < 5){
                throw new RuntimeException(name+"执行任务过程中出现运行时异常");
            }
            Thread.sleep(1000);
        }
    }
}
