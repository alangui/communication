package com.qing.niu.zk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/3/17 2:33
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Provider.class);

    public static void main(String[] args) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Provider provider = new Provider();
                    try {
                        provider.registry();
                    } catch (Exception e) {
                        logger.error("注册异常:{}", e);
                    }
                }
            }).start();
            Thread.sleep(1000L);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Consumer consumer = new Consumer();
                    try {
                        List<String> serverList = consumer.search();
                        logger.info("获取服务列表:{}",serverList);
                        Thread.sleep(300000L);
                    } catch (Exception e) {
                        logger.error("查询服务异常:{}",e);
                    }
                }
            }).start();
            Thread.sleep(5000);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Consumer consumer = new Consumer();
                    try {
                        List<String> serverList = consumer.search();
                        logger.info("获取服务列表:{}",serverList);
                        Thread.sleep(300000L);
                    } catch (Exception e) {
                        logger.error("查询服务异常:{}",e);
                    }
                }
            }).start();
            Thread.sleep(600000L);
        } catch (Exception e) {
            logger.error("系统异常:{}", e);
        }
    }
}
