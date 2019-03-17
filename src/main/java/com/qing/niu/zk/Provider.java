package com.qing.niu.zk;

import com.qing.niu.util.IpUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
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
public class Provider extends AbstractService {

    private static Logger logger = LoggerFactory.getLogger(Provider.class);

    public void registry() throws Exception {
        init();
        Stat rootStat = zookeeperManager.existed(ROOT_PATH);
        if (null == rootStat) {
            zookeeperManager.createPath(ROOT_PATH);
            logger.info("zookeeper节点{}创建成功", ROOT_PATH);
        }
        Stat serverListStat = zookeeperManager.existed(SERVER_PATH);
        if (null == serverListStat) {
            zookeeperManager.createPath(SERVER_PATH);
            logger.info("zookeeper节点{}创建成功", SERVER_PATH);
        }
        //注册 server Node
        String serverNode = SERVER_PATH + "/server_" + IpUtils.getLocalIP().replaceAll("\\.", "_");
        String serverData = IpUtils.getLocalIP() + ":8080";
        Stat serverNodeStat = zookeeperManager.existed(serverNode);
        if (null == serverNodeStat) {
            zookeeperManager.createPath(serverNode, serverData.getBytes("UTF-8"), CreateMode.EPHEMERAL);
            logger.info("zookeeper节点{}创建成功", serverNode);
        }
        logger.info("服务地址注册完成:{}", serverData);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
    }
}