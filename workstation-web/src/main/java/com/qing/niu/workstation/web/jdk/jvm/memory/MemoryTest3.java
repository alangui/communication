package com.qing.niu.workstation.web.jdk.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * <p>
 *     方法区产生内存溢出异常
 *     -XX:MaxMetaspaceSize=10m
 *
 *     Java 永久代去哪儿了
 *     https://www.infoq.cn/article/Java-PERMGEN-Removed
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/25 0:05
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MemoryTest3 {

    public static void main(String[] args) {
        for (;;){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MemoryTest3.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy) -> proxy.invokeSuper(obj,args1));

            System.out.println("hello world");
            enhancer.create();
        }
    }
}
