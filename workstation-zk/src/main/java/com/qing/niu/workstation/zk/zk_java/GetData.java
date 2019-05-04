package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/4
 */
public class GetData implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(GetData.class);

    private ZooKeeper zooKeeper = null;

    private Stat stat = new Stat();

    public void getData(){
        zooKeeper = new CreateSession().createSession(this);
        try {
            byte[] bytes = zooKeeper.getData("/test",this,stat);
            logger.info("获取到数据:{},{}",new String(bytes),stat.getVersion());
            zooKeeper.setData("/test","this is test node".getBytes(),-1);
        } catch (KeeperException e) {
            logger.error("KeeperException:{}", e);
        } catch (InterruptedException e) {
            logger.error("InterruptedException:{}", e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("GetNode 收到 watch event:{}",watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            CreateSession.countDownLatch.countDown();
            if (Event.EventType.NodeDataChanged == watchedEvent.getType()) {
                try {
                    byte[] bytes = zooKeeper.getData(watchedEvent.getPath(),true,stat);
                    logger.info("{},{}", new String(bytes),stat.getVersion());
                } catch (KeeperException e) {
                    logger.error("KeeperException:{}", e);
                } catch (InterruptedException e) {
                    logger.error("InterruptedException:{}", e);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        GetData getData = new GetData();
        getData.getData();
        Thread.sleep(1000L);
    }
}
