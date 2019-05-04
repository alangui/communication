package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
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
public class DeleteNode implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(DeleteNode.class);

    public void delete(){
        CreateSession createSession = new CreateSession();
        ZooKeeper zooKeeper = createSession.createSession();

        try {
            zooKeeper.delete("/test/persistent",0);
            logger.info("删除节点");
        } catch (InterruptedException e) {
            logger.error("KeeperException:{}",e);
        } catch (KeeperException e) {
            logger.error("InterruptedException:{}",e);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.delete();
    }
}
