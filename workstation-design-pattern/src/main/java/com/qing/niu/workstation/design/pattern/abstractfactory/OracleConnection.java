package com.qing.niu.workstation.design.pattern.abstractfactory;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/24
 * @ProjectName communication
 * @Version 1.0.0
 */
public class OracleConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("oracle connected.");
    }
}
