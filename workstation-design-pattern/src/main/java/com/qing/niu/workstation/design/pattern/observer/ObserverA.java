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
public class ObserverA implements Observer{

    @Override
    public void response() {
        System.out.println("具体观察者A做出反应");
    }
}
