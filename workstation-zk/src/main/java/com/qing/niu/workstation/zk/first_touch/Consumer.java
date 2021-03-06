package com.qing.niu.workstation.zk.first_touch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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
public class Consumer extends AbstractService {

    private static Logger logger = LoggerFactory.getLogger(Consumer.class);

    private static List<String> serverList = new ArrayList<>();

    public List<String> search() throws IOException {
        if (!serverList.isEmpty()){
            logger.info("从本地缓存中查询到provider服务器列表");
            return serverList;
        }
        init();
        return queryServerList();
    }

    public List<String> queryServerList() throws IOException {
        try {
            Stat rootStat = zookeeperManager.existed(ROOT_PATH);
            if (null == rootStat){
                logger.error("zookeeper节点{}不存在",ROOT_PATH);
                return new ArrayList<>();
            }
            Stat serverStat = zookeeperManager.existed(SERVER_PATH);
            if (null == serverStat){
                logger.error("zookeeper节点{}不存在",SERVER_PATH);
                return new ArrayList<>();
            }
            List<String> nodes = zookeeperManager.getChild(SERVER_PATH,this);
            logger.info("查询到共有{}服务节点:{}",nodes.size(),nodes);
            serverList.clear();
            for (String node : nodes){
                byte[] bytes = zookeeperManager.getData(SERVER_PATH + "/" + node);
                serverList.add(new String(bytes,"UTF-8"));
                logger.info("服务节点：{},数据:{}",node,new String(bytes,"UTF-8"));
            }
        } catch (Exception e) {
            logger.error("获取服务异常:{}",e.getMessage());
        } finally {
            return serverList;
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.warn("监听到服务节点变换:{}",watchedEvent);
        if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                && SERVER_PATH.equals(watchedEvent.getPath())){
            try {
                queryServerList();
            } catch (IOException e) {
                logger.error("IO Exception:{}",e.getMessage());
            }
        }
    }
}
