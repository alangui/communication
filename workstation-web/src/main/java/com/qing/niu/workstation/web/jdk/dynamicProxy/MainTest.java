package com.qing.niu.workstation.web.jdk.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/2/11 15:37
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MainTest {

    public static void main(String[] args) throws Exception{
        //被代理类实现接口被代理
        TestInterface test1 = (TestInterface) new DynamicProxy1(new TestClass1()).getProxy();
        test1.method1();
        test1.toString();

        //被代理接口不实现接口被代理
        TestInterface test2 = (TestInterface) new DynamicProxy2(new TestClass2()).getProxy();
        test2.method1();
        test2.toString();

        //生成的代理类class文件
        byte[] classFile = ProxyGenerator.generateProxyClass("proxy1",
                new Class[]{TestInterface.class});
        FileOutputStream fileOutputStream = new FileOutputStream(new File("TestClass1.class"));
        fileOutputStream.write(classFile);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
