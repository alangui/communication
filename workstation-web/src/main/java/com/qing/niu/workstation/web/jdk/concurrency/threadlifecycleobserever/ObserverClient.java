package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("====================");
        subject.setState(10);

        System.out.println("====================");
        subject.setState(10);

        System.out.println("====================");
        subject.setState(100);
    }
}
