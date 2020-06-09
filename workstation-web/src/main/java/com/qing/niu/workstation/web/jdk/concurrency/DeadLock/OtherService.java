package com.qing.niu.workstation.web.jdk.concurrency.DeadLock;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/7 17:56
 * @ProjectName communication
 * @Version 1.0.0
 */
public class OtherService {

    private final Object lock = new Object();

    private DeadLock deadLock;

    public void s1(){
        synchronized (lock){
            System.out.println("s1=============");
        }
    }

    public void s2(){
        synchronized (lock){
            System.out.println("m2=============");
            deadLock.m2();
        }
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
