package com.qing.niu.java.concurrency.MultiConditionOnLock;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/4
 */
public class Producer implements Runnable{

    private FileMock fileMock;
    private Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer){
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while(fileMock.hasMoreLines()){
            buffer.insert(fileMock.getLines());
        }
        buffer.setPendingLines(false);
    }
}
