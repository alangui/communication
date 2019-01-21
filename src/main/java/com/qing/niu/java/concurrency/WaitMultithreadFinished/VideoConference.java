package com.qing.niu.java.concurrency.WaitMultithreadFinished;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/5 15:03
 * @ProjectName communication
 * @Version 1.0.0
 */
public class VideoConference implements Runnable{

    private Logger logger = LoggerFactory.getLogger(VideoConference.class);

    private final CountDownLatch countDownLatch;

    public VideoConference(int number){
        this.countDownLatch = new CountDownLatch(number);
    }

    public void arrive(String name){
        logger.info("{} has arrived",name);
        countDownLatch.countDown();
        logger.info("video conference waiting for {} parcitipants",countDownLatch.getCount());
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            logger.info("all participants has arrived, the video conference begin!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
