package com.qing.niu.zk;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/16
 */
public class ZookeeperBeanFactory {

    private static final int SESSION_TIME = 2 * 1000;

    private String hosts;

    private Watcher watcher;

    public ZookeeperBeanFactory(){}

    public ZookeeperBeanFactory(String hosts, Watcher watcher){
        this.hosts = hosts;
        this.watcher = watcher;
    }

    public ZooKeeper getZooKeeper() throws IOException {
        return new ZooKeeper(hosts,SESSION_TIME,watcher);
    }
}
