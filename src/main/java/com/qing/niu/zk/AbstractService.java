package com.qing.niu.zk;

import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/16
 */
public abstract class AbstractService implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(AbstractService.class);

    protected String ROOT_PATH = "/root";

    protected String SERVER_PATH = ROOT_PATH + "/service";

    protected ZookeeperManager zookeeperManager;

    protected void init() throws IOException {
        String zookeeperAddress = "192.168.67.146:2181,192.168.67.147:2181,192.168.67.148:2181";
        ZookeeperBeanFactory zookeeperBeanFactory = new ZookeeperBeanFactory(zookeeperAddress,this);
        zookeeperManager = new ZookeeperManager(zookeeperBeanFactory.getZooKeeper());
        logger.info("zk 连接成功...");
    }

}
