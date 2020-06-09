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
public class DeadLock {

    private OtherService otherService = new OtherService();

    private final Object lock = new Object();

    public DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (lock){
            System.out.println("m1===========");
            otherService.s1();
        }
    }

    public void m2(){
        synchronized (lock){
            System.out.println("m2===========");
        }
    }
}
