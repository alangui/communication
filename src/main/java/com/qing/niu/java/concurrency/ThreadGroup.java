package com.qing.niu.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/3
 */
public class ThreadGroup implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(ThreadGroup.class);

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        logger.info("thread {} start",name);
        Random random = new Random((new Date()).getTime());
        int value = (int)(random.nextDouble() * 100);
        logger.info("thread {}:{}",name,value);
        try {
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            logger.warn("thread {}: interrupted",name);
            return;
        }
        logger.info("thread {}: end",name);
    }

    public static void main(String[] args) {
        java.lang.ThreadGroup threadGroup = new java.lang.ThreadGroup("search");
        ThreadGroup task = new ThreadGroup();
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(threadGroup,task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        logger.info("number of thread:{}",threadGroup.activeCount());
        logger.info("information about the thread group");
        threadGroup.list();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i=0; i < threadGroup.activeCount(); i++){
            logger.info("thread {}:{}",threads[i].getId(),threads[i].getState());
        }
        while (threadGroup.activeCount() > 9){
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                logger.warn("thread is wake up");
            }
        }
        threadGroup.interrupt();
    }
}
