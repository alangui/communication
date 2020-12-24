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
public class OracleDatabase implements Database{

    @Override
    public Connection getConnection() {
        return new OracleConnection();
    }

    @Override
    public Command getCommand() {
        return new OracleCommand();
    }
}
