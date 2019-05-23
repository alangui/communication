package com.qing.niu.workstation.web.jdk.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2018/12/27
 */
public class SetAndGetThreadInfo implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(SetAndGetThreadInfo.class);

    private int number;

    public SetAndGetThreadInfo(int number){
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            logger.info("{}: {} * {} = {}", Thread.currentThread().getName(), number,i,number * i);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(new SetAndGetThreadInfo(i));
            if (i < 5){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("thread-"+i);
        }
        for (int i = 0; i < 10; i++ ){
            states[i] = threads[i].getState();
            logger.info("status of {}:{}",threads[i].getName(),states[i]);
        }
        for (int i = 0; i < 10; i++){
            threads[i].start();
        }
        boolean finishFlag = false;
        while(!finishFlag){
            for (int i = 0; i < 10; i++){
                //某对象调用wait()或者notify()前,必须使用synchronzied语义绑定住调用该对象，否则会抛出IllegalMonitorStateException
                //IllegalMonitorStateException的JavaDoc注释
                //Thrown to indicate that a thread has attempted to wait on an object's monitor or
                // to notify other threads waiting on an object's monitor without owning the specified monitor.
                //当一个线程尝试在某对象的监视器里等待或唤醒其他线程前未获取该对象监视器时会抛出提示（非法监视器状态异常）
                synchronized (threads[i]){
                    try {
                        //获取某时间点线程信息
                        threads[i].wait(10L);
                    } catch (InterruptedException e) {
                        logger.debug("{} wake up",threads[i].getName());
                    }
                }
                //由于线程执行速度非常快，下面信息仅提供线程生命周期状态变换的感受展示
                if (threads[i].getState() != states[i]){
                    logger.warn("status of {} changed,",threads[i].getName());
                    logger.warn("{} Id:{} Priority:{} Old State:{} New State:{}",
                            threads[i].getName(),threads[i].getId(),threads[i].getPriority(),states[i],threads[i].getState());
                    states[i] = threads[i].getState();
                }
            }
            //终止main线程
//            finishFlag = true;
//            for (int i = 0; i < 10; i++){
//                finishFlag = finishFlag && threads[i].getState() == Thread.State.TERMINATED;
//                if (!finishFlag){
//                    break;
//                }
//            }
        }
    }
}
