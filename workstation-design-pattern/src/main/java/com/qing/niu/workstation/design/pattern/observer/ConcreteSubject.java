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
public class ConcreteSubject extends Subject{

    @Override
    public void notifyObservers() {
        System.out.println("具体目标发生改变...");
        System.out.println("-----------------");

        for (Observer observer : observers) {
            observer.response();
        }
    }
}
