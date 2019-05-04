package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.*;
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
public class GetNode implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(GetNode.class);

    private ZooKeeper zooKeeper = null;

    public void get(){
        CreateSession createSession = new CreateSession();
        zooKeeper = createSession.createSession(this);

        try {
            List<String> list = zooKeeper.getChildren("/test",true);
            logger.info("获取子节点列表:{}",list);

            String path = zooKeeper.create("/test/persistent","".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            logger.info("创建节点:{}",path);
        } catch (KeeperException e) {
            logger.error("KeeperException:{}",e);
        } catch (InterruptedException e) {
            logger.error("InterruptedException:{}",e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("GetNode 收到 watch event:{}",watchedEvent);
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            CreateSession.countDownLatch.countDown();
            if (Event.EventType.NodeChildrenChanged == watchedEvent.getType()) {
                try {
                    List list = zooKeeper.getChildren(watchedEvent.getPath(), true);
                    logger.info("{}", list);
                } catch (KeeperException e) {
                    logger.error("KeeperException:{}", e);
                } catch (InterruptedException e) {
                    logger.error("InterruptedException:{}", e);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        GetNode getNode = new GetNode();
        getNode.get();
        Thread.sleep(1000L);
    }
}
