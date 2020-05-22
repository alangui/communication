package com.qing.niu.workstation.spring.circledependence;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/21 20:29
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TestA {

    private TestB testB;

    public void a(){
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
