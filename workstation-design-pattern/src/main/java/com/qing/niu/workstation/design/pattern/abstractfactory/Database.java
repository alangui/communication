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
public interface Database {

    /**
     * 获取连接
     *
     * @return 连接
     */
    Connection getConnection();

    /**
     * 指令器
     *
     * @return 指令器
     */
    Command getCommand();
}
