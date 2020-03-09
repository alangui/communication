package com.qing.niu.workstation.web.jdk.base;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/3 15:09
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Overload {

    public void add(String s1, String s2){
        System.out.println("---------");
        System.out.println(s1 + s2);
    }

    public void add(Object o1, Object o2){
        System.out.println("==========");
        System.out.println(o1);
        System.out.println(o2);
    }

    public static void sub(int a, int b){
        System.out.println(a - b);
    }
}
