package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:19
 * @ProjectName communication
 * @Version 1.0.0
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("octal String : " + Integer.toOctalString(subject.getState()));
    }
}
