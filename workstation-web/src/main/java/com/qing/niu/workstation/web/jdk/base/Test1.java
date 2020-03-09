package com.qing.niu.workstation.web.jdk.base;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/3 14:49
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.add("hi","I am iron");

        Overload.sub(10,5);
        Overload subOverload = new SubOverload();
        subOverload.sub(10,5);
        SubOverload.sub(10,5);
    }
}
