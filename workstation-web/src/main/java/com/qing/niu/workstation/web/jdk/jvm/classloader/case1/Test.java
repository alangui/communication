package com.qing.niu.workstation.web.jdk.jvm.classloader.case1;

import com.qing.niu.workstation.web.jdk.jvm.classloader.CustomizeClassLoader;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/18 16:46
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        CustomizeClassLoader customizeClassLoader = new CustomizeClassLoader("classLoader1");
        customizeClassLoader.setPath("E:\\personal project\\communication\\classfile\\");
        //使用自定义类加载器加载MySample，将编译后的文件移动到指定目录D:\\IdeaProject\\gjk-maven\\classfile\\下
        Class<?> clazz = customizeClassLoader.loadClass("com.qing.niu.workstation.web.jdk.jvm.classloader.case1.MySample");
        System.out.println("class:" + clazz.hashCode());
        //MySample和Mycat不是同一个类加载器加载的
        Object object = clazz.newInstance();
    }
}
