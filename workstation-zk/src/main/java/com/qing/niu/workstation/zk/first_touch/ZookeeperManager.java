package com.qing.niu.workstation.zk.first_touch;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/16
 */
public class ZookeeperManager {

    private ZooKeeper zooKeeper;

    public ZookeeperManager(ZooKeeper zooKeeper){
        this.zooKeeper = zooKeeper;
    }

    public void createPath(String path) throws UnsupportedEncodingException, KeeperException, InterruptedException {
        createPath(path,path.getBytes("UTF-8"));
    }

    public void createPath(String path, byte[] data) throws KeeperException, InterruptedException {
        createPath(path,data,CreateMode.PERSISTENT);
    }

    public void createPath(String path, byte[] data, CreateMode createMode) throws KeeperException, InterruptedException {
        zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE,createMode);
    }

    public Stat existed(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path,false);
    }

    public byte[] getData(String path) throws KeeperException, InterruptedException {
        return zooKeeper.getData(path,false,null);
    }

    public List<String> getChild(String path, Watcher watcher) throws KeeperException, InterruptedException{
        try {
            return zooKeeper.getChildren(path,watcher);
        } catch (KeeperException e) {
            return new ArrayList<>();
        } catch (InterruptedException e) {
            throw e;
        }
    }

    public boolean getState(){
        ZooKeeper.States states = zooKeeper.getState();
        return states.isAlive();
    }

    public void close(){
        try {
            zooKeeper.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
