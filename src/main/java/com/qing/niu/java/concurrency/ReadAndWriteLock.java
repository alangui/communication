package com.qing.niu.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/3
 */
public class ReadAndWriteLock {

    private static Logger logger = LoggerFactory.getLogger(ReadAndWriteLock.class);

    private double price1;

    private double price2;

    private ReadWriteLock lock;

    public ReadAndWriteLock(){
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1(){
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2(){
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrice(double price1, double price2){
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }

    public static class Reader implements Runnable{

        private ReadAndWriteLock readAndWriteLock;

        public Reader(ReadAndWriteLock readAndWriteLock){
            this.readAndWriteLock = readAndWriteLock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                logger.info("{}: price1:{}",Thread.currentThread().getName(),readAndWriteLock.getPrice1());
                logger.info("{}: price2:{}",Thread.currentThread().getName(),readAndWriteLock.getPrice2());
            }
        }
    }

    public static class Writer implements Runnable{

        private ReadAndWriteLock readAndWriteLock;

        public Writer(ReadAndWriteLock readAndWriteLock){
            this.readAndWriteLock = readAndWriteLock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++){
                logger.info("writer: attempt to modify the prices");
                readAndWriteLock.setPrice(Math.random()*10,Math.random()*8);
                logger.info("writer: prices have been modified");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReadAndWriteLock readAndWriteLock = new ReadAndWriteLock();
        Reader reader = new Reader(readAndWriteLock);
        Thread[] readThreads = new Thread[5];
        for (int i = 0; i < 5; i++){
            readThreads[i] = new Thread(reader);
            readThreads[i].start();
        }

        Writer writer = new Writer(readAndWriteLock);
        Thread[] writerThreads = new Thread[5];
        for (int i = 0; i < 5; i++){
            writerThreads[i] = new Thread(writer);
            writerThreads[i].start();
        }
    }
}
