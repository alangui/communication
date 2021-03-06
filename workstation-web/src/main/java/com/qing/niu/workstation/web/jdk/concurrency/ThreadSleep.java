package com.qing.niu.workstation.web.jdk.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/2
 */
public class ThreadSleep implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(ThreadSleep.class);

    @Override
    public void run() {
        while (true) {
            logger.info("{}", new Date());
            try {
                synchronized (this) {
                    wait();
                }
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                logger.warn("thread sleep wake up");
            }
        }
    }

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        logger.info("main线程名信息:{}、{}、{}、{}、{}、{}、{}",
                main.getId(),
                main.getName(),
                main.getThreadGroup().getMaxPriority(),
                main.getPriority(),
                main.getContextClassLoader(),
                main.getState(),
                main.getStackTrace());
        Thread task = new Thread(new ThreadSleep());
        task.start();
        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
        logger.info("main thread is over");
    }
}
