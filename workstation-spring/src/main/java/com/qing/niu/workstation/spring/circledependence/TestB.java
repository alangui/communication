package com.qing.niu.workstation.spring.circledependence;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/21 20:30
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestB {

    private TestC testC;

    public void b(){
        testC.c();
    }

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
