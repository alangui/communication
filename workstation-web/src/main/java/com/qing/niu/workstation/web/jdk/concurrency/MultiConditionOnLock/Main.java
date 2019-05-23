package com.qing.niu.workstation.web.jdk.concurrency.MultiConditionOnLock;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/4
 */
public class Main {

    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100,10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(fileMock,buffer);
        Thread producerThread = new Thread(producer,"producer");
        producerThread.start();
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 3; i++){
            Thread thread = new Thread(consumer);
            thread.start();
        }
    }
}
