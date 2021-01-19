package com.qing.niu.workstation.dal.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
@Data
public class TableProjectADO implements Serializable {
    private static final long serialVersionUID = -3254856254239856638L;

    private Integer id;

    private String wxid;

    private String name;

    private Date createTime;
}
