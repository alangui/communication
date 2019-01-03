package com.qing.niu.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/3
 */
public class Lock {

    private static Logger logger = LoggerFactory.getLogger(Lock.class);

    private final java.util.concurrent.locks.Lock queuelock = new ReentrantLock();

    public void printJob(Object document){
        queuelock.lock();
        try {
            Long duration = (long) (Math.random()*10000);
            logger.info("{}:print queue: printing a job during {} seconds",Thread.currentThread().getName(),(duration/1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            logger.info("interrupt exception occur");
        } finally {
            queuelock.unlock();
        }
    }

    public static class Job implements Runnable{

        private Lock lock;

        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            logger.info("{}: going to print a document",Thread.currentThread().getName());
            lock.printJob(new Object());
            logger.info("{}: the document has been printed",Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Job job = new Job(new Lock());
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(job,"thread " + i);
            threads[i].start();
        }
    }
}
