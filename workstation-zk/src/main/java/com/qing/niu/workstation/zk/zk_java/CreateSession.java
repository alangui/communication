package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/4
 */
public class CreateSession implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(CreateSession.class);

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static String zookeeperAddress = "192.168.67.146:2181,192.168.67.147:2181,192.168.67.148:2181";

    public ZooKeeper createSession(){
        return createSession(null);
    }

    public ZooKeeper createSession(Watcher watcher){
        watcher = watcher == null ? new CreateSession() : watcher;
        try {
            ZooKeeper zk = new ZooKeeper(zookeeperAddress,5000,watcher);
            logger.info("连接zk:{}",zk);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                logger.error("{}",e);
            }
            logger.info("连接zk:{}",zk);
            return zk;
        } catch (IOException e) {
            logger.error("{}",e);
        }
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("收到 watch event:{}",watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()){
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        CreateSession createSession = new CreateSession();
        createSession.createSession();
    }
}
