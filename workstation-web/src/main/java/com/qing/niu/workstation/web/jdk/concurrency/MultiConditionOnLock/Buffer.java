package com.qing.niu.workstation.web.jdk.concurrency.MultiConditionOnLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/4
 */
public class Buffer {

    private Logger logger = LoggerFactory.getLogger(Buffer.class);

    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize){
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line){
        lock.lock();
        logger.info("{} obtain lock",Thread.currentThread().getName());
        try {
            while (buffer.size() == maxSize){
                logger.info("{} satisfy wait condition, release lock",Thread.currentThread().getName());
                space.await();
                logger.info("{} notified",Thread.currentThread().getName());
            }
            logger.info("{} insert line",Thread.currentThread().getName());
            buffer.offer(line);
            logger.info("{}: inserted line:{},the size of buffer is {}",Thread.currentThread().getName(),line,buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            logger.warn("interrupted exception");
        } finally {
            lock.unlock();
        }
    }

    public String get(){
        String line = null;
        lock.lock();
        try {
            while((buffer.size() == 0) && hasPendingLines()){
                lines.await();
            }
            if (hasPendingLines()){
                line = buffer.poll();
                logger.info("{} line read: {},the size of buffer is {}",Thread.currentThread().getName(),line,buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            logger.warn("interrupted exception");
        } finally {
            lock.unlock();
        }
        return line;
    }

    public boolean hasPendingLines(){
        return pendingLines || buffer.size() > 0;
    }

    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }
}
