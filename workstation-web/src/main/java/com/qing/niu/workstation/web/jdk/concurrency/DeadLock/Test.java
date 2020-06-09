package com.qing.niu.workstation.web.jdk.concurrency.DeadLock;

/**
 * <p>
 *     jps 获取PID
 *     jstack PID 获取线程栈信息（死锁信息）
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/7 18:04
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread(() -> {
            while(true){
                deadLock.m1();
            }
        }).start();

        new Thread(() -> {
            while (true){
                otherService.s2();
            }
        }).start();
    }
}
