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
public class TestC {

    private TestA testA;

    public void c(){
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
