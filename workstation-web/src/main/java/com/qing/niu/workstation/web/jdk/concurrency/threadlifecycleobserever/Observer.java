package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:13
 * @ProjectName communication
 * @Version 1.0.0
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();

}
