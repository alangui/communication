package com.qing.niu.workstation.web.jdk.jvm.bytecode;

/**
 * <p>
 *     字节码初探
 *     查看class文件
 *     javap Test1           简单信息
 *     javap -c Test1        较详细信息
 *     javap -verbose Test1  详细信息
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/5 13:59
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
