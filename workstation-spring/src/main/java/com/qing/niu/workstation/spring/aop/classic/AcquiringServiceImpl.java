package com.qing.niu.workstation.spring.aop.classic;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/24 0:05
 * @ProjectName communication
 * @Version 1.0.0
 */
public class AcquiringServiceImpl implements AcquiringService{

    @Override
    public void realTime() {
        System.out.println("实时交易");
    }
}
