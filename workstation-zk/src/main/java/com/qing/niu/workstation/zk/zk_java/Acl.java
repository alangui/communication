package com.qing.niu.workstation.zk.zk_java;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
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
public class Acl {

    private static Logger logger = LoggerFactory.getLogger(Acl.class);

    public void authCreate(){
        ZooKeeper zooKeeper = new CreateSession().createSession();
        zooKeeper.addAuthInfo("digest","acl:true".getBytes());
        try {
            String path = zooKeeper.create("/test/auth","auth".getBytes(),
                    ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
            logger.info("创建节点:{}",path);

            //NoAuth for /test/auth
            ZooKeeper zooKeeper1 = new CreateSession().createSession();
            zooKeeper1.getData("/test/auth",false,null);
            //NoAuth for /test/auth
            ZooKeeper zooKeeper2 = new CreateSession().createSession();
            zooKeeper2.addAuthInfo("digest","acl:false".getBytes());
            zooKeeper2.getData("/test/auth",false,null);

            ZooKeeper zooKeeper3 = new CreateSession().createSession();
            zooKeeper3.addAuthInfo("digest","acl:true".getBytes());
            byte[] bytes3 = zooKeeper3.getData("/test/auth",false,null);
            logger.info("获取节点数据:{}",new String(bytes3));
        } catch (KeeperException e) {
            logger.error("KeeperException:{}",e);
        } catch (InterruptedException e) {
            logger.error("InterruptedException:{}",e);
        }
    }

    public void deleteAuth() throws Exception{
        ZooKeeper zooKeeper = new CreateSession().createSession();
        zooKeeper.addAuthInfo("digest","acl:true".getBytes());

        zooKeeper.create("/test/auth/child","child".getBytes(),
                ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);

        ZooKeeper zooKeeper1 = new CreateSession().createSession();
        zooKeeper1.addAuthInfo("digest","acl:true".getBytes());
        zooKeeper1.delete("/test/auth/child",-1);
        logger.info("成功删除节点:{}","/test/auth/child");

        ZooKeeper zooKeeper2 = new CreateSession().createSession();
        zooKeeper2.delete("/test/auth",-1);
        logger.info("成功删除节点:{}","/test/auth");
    }

    public static void main(String[] args) throws Exception{
        new Acl().authCreate();
        new Acl().deleteAuth();
    }
}
