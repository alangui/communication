package com.qing.niu.workstation.web.jdk.concurrency.MultiConditionOnLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/4
 */
public class Consumer implements Runnable{

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()){
            logger.info("consumer get line {}",buffer.get());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
