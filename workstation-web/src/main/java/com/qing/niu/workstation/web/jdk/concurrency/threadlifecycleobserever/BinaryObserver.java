package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:17
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("binary String : " + Integer.toBinaryString(subject.getState()));
    }
}
