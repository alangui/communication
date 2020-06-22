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
public class MyCat {

    public MyCat(){
        System.out.println("Mycat is loaded by " + this.getClass().getClassLoader());
    }

}
