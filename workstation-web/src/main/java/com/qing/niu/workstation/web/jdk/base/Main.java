package com.qing.niu.workstation.web.jdk.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/4 20:48
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = new B();
        Method set = a.getClass().getMethod("setAgentToken",String.class);
        set.invoke(a,"gg");
        Method get = a.getClass().getMethod("getAgentToken");
        System.out.println(get.invoke(a));
    }
}
