package com.qing.niu.workstation.web.jdk.base;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/27 0:31
 * @ProjectName communication
 * @Version 1.0.0
 */
public class SystemInfo {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
