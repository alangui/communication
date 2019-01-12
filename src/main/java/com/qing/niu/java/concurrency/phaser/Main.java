package com.qing.niu.java.concurrency.phaser;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Phaser;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/12 13:31
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("/data","log",phaser);
        FileSearch app = new FileSearch("","log",phaser);
        FileSearch document = new FileSearch("","log",phaser);

        Thread systemThread = new Thread(system,"system");
        systemThread.start();
        Thread appThread = new Thread(app,"app");
        appThread.start();
        Thread documentThread = new Thread(document,"document");
        documentThread.start();

        try {
            systemThread.join();
            appThread.join();
            documentThread.join();
        } catch (InterruptedException e) {
            logger.error("interrupt exception:{}",Throwables.getStackTraceAsString(e));
        }
        logger.info("thread of main terminated:{}",phaser.isTerminated());
    }
}
