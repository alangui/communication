package com.qing.niu.workstation.web.jdk.jvm.classloader.case1;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/18 16:45
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MySample {

    public MySample(){
        System.out.println("MySample is loaded by " + this.getClass().getClassLoader());

        new MyCat();
    }

}
