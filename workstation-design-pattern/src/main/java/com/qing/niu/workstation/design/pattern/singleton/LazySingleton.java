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
public class LazySingleton {

    private volatile static LazySingleton singleton;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (null == singleton) {
            synchronized (LazySingleton.class) {
                if (null == singleton) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    /** 其它实例方法 **/
    public void connection(){
    }

}
