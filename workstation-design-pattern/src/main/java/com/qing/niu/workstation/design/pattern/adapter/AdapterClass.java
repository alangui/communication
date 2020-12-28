package com.qing.niu.workstation.design.pattern.adapter;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AdapterClass extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }
}
