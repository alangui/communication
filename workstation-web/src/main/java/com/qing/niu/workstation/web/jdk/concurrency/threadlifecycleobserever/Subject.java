package com.qing.niu.workstation.web.jdk.concurrency.threadlifecycleobserever;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/13 18:12
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        if (state == this.state){
            return;
        }
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers(){
        observers.stream().forEach(observer -> observer.update());
    }
}
