package com.qing.niu.java.concurrency.WaitMultithreadFinished;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/5 15:18
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Participants implements Runnable{

    private Logger logger = LoggerFactory.getLogger(Participants.class);

    private VideoConference videoConference;

    private String name;

    public Participants(VideoConference videoConference, String name){
        this.videoConference = videoConference;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            long sleepTime = new Double(Math.random()*10).longValue();
            logger.info("{} sleep {} seconds",name,sleepTime);
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}
