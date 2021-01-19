package com.qing.niu.workstation.dal.dao;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/14
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.dal.dao
 * @Version 1.0.0
 */
public interface TableProjectAMapper {

    TableProjectADO selectById(Integer id);

    int insert(TableProjectADO tableProjectADo);
}
