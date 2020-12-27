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
public class MysqlConnection implements Connection {

    @Override
    public void connect() {
        System.out.println("mysql connected.");
    }
}
