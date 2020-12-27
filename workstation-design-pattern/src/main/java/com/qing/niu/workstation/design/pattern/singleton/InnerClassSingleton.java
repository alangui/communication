package com.qing.niu.workstation.design.pattern.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
        if (null != InnerClassHolder.SINGLETON){
            throw new RuntimeException("单例对象已经生成");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.SINGLETON;
    }

    private static class InnerClassHolder {
        private final static InnerClassSingleton SINGLETON = new InnerClassSingleton();
    }

    /** 其它实例方法 **/
    public void connection(){
    }
}
