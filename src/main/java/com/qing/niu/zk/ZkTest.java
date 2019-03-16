package com.qing.niu.zk;

import com.qing.niu.util.IpUtils;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/16
 */
public class ZkTest implements Watcher{

    private static Logger logger = LoggerFactory.getLogger(ZkTest.class);

    private String ROOT_PATH = "/root";

    private String SERVER_LIST = ROOT_PATH + "/serverList";

    public static void main(String[] args){
        ZkTest zkTest = new ZkTest();
        try {
            zkTest.registry();
        } catch (Exception e) {
            logger.error("注册异常:{}",e);
        }
    }

    public void registry() throws Exception{
        String zookeeperAddress = "192.168.79.152:2181,192.168.79.153:2181,192.168.79.154:2181";
        ZookeeperBeanFactory zookeeperBeanFactory = new ZookeeperBeanFactory(zookeeperAddress,this);
        ZookeeperManager zookeeperManager = new ZookeeperManager(zookeeperBeanFactory.getZooKeeper());
        logger.info("zk 连接成功...");
        Stat rootStat = zookeeperManager.existed(ROOT_PATH);
        if (null == rootStat){
            zookeeperManager.createPath(ROOT_PATH);
            logger.info("zookeeper节点{}创建成功",ROOT_PATH);
        }
        Stat serverListStat = zookeeperManager.existed(SERVER_LIST);
        if (null == serverListStat){
            zookeeperManager.createPath(SERVER_LIST);
            logger.info("zookeeper节点{}创建成功",SERVER_LIST);
        }
        //注册 server Node
        String serverNode = SERVER_LIST + "/" + IpUtils.getLocalIP().replaceAll("\\.","_");
        Stat serverNodeStat = zookeeperManager.existed(serverNode);
        if (null == serverNodeStat){
            zookeeperManager.createPath(serverNode);
            logger.info("zookeeper节点{}创建成功",serverNode);
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
