package com.qing.niu.workstation.design.pattern.singleton;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class HungrySingleton {

    private final static HungrySingleton SINGLETON = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return SINGLETON;
    }

    /** 其它实例方法 **/
    public void connection(){
    }
}
