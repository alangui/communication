package com.qing.niu.workstation.web.jdk.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/11 15:03
 * @ProjectName communication
 * @Version 1.0.0
 */
public class DynamicProxy1 implements InvocationHandler{

    private Object source;

    public DynamicProxy1(Object source){
        super();
        this.source = source;
    }

    public void before(){
        System.out.println("do something before proxy method executed");
    }

    public void after(){
        System.out.println("do something after proxy method executed");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("toString")){
            before();
        }
        Object result = method.invoke(source,args);
        if (method.getName().equals("toString")){
            System.out.println(result);
            after();
        }
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(getClass().getClassLoader(),source.getClass().getInterfaces(),this);
    }
}
