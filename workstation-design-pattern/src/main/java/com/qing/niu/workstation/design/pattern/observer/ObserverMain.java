package com.qing.niu.workstation.design.pattern.observer;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/30
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ObserverMain {

    public static void main(String[] args) {
        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();
        Subject subject = new ConcreteSubject();
        subject.add(observerA);
        subject.add(observerB);
        subject.notifyObservers();
    }
}
