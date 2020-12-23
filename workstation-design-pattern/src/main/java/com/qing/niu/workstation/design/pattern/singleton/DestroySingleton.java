package com.qing.niu.workstation.design.pattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/23
 * @ProjectName communication
 * @Version 1.0.0
 */
public class DestroySingleton {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton singleton = declaredConstructor.newInstance();
        InnerClassSingleton singleton1 = InnerClassSingleton.getInstance();
        System.out.println(singleton == singleton1);
    }
}
