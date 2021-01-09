package com.qing.niu.workstation.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/30
 * @ProjectName communication
 * @Version 1.0.0
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 触发通知观察者
     */
    public abstract void notifyObservers();
}
