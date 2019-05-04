package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/4
 */
public class CreateNode implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(CreateNode.class);

    public void createNode(){
        CreateSession createSession = new CreateSession();
        ZooKeeper zooKeeper = createSession.createSession();

        try {
            String path = zooKeeper.create("/test","this is a persistent node".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            logger.info("创建节点:{}",path);

            String path1 = zooKeeper.create("/test/persistent","/test/persistent".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            logger.info("创建节点:{}",path1);

            String path2 = zooKeeper.create("/test/persistent-s","persistent-s".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
            logger.info("创建节点:{}",path2);

            String path3 = zooKeeper.create("/test/persistent-s","persistent-s".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
            logger.info("创建节点:{}",path3);

            String path4 = zooKeeper.create("/test/ephemeral","/test/ephemeral".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
            logger.info("创建节点:{}",path4);

            String path5 = zooKeeper.create("/test/ephemeral-e","ephemeral-e".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
            logger.info("创建节点:{}",path5);

            String path6 = zooKeeper.create("/test/ephemeral-e","ephemeral-e".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
            logger.info("创建节点:{}",path6);

            Thread.sleep(10000);

        } catch (KeeperException e) {
            logger.error("KeeperException:{}",e);
        } catch (InterruptedException e) {
            logger.error("InterruptedException:{}",e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("created node 收到watch event：{}",watchedEvent);
    }

    public static void main(String[] args) {
        CreateNode createNode = new CreateNode();
        createNode.createNode();
    }
}
