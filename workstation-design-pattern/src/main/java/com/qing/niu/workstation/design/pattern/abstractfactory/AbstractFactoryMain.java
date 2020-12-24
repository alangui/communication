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
public class AbstractFactoryMain {

    public static void main(String[] args) {
        Database mysql = new MysqlDatabase();
        mysql.getConnection().connect();
        mysql.getCommand().command();

        Database oracle = new OracleDatabase();
        oracle.getConnection().connect();
        oracle.getCommand().command();
    }
}
