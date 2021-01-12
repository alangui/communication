package com.qing.niu.workstation.spring.aop.annotation1;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/12
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.spring.aop.annotation1
 * @Version 1.0.0
 */
public interface Calculate {

    int add(int numA, int numB);

    int reduce(int numA, int numB);

    int div(int numA, int numB);

    int multi(int numA, int numB);
}
