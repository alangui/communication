package com.qing.niu.java.concurrency.MutithreadWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/6 14:16
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Group implements Runnable {

    private Logger logger = LoggerFactory.getLogger(Group.class);
    private Result result;

    public Group(Result result){
        this.result = result;
    }

    @Override
    public void run() {
        logger.info("group processing result...");
        int[] data = result.getData();
        int finalCount = 0;
        for (int i = 0; i < data.length; i++){
            finalCount+=data[i];
        }
        logger.info("group processed total result:{}",finalCount);
    }
}
