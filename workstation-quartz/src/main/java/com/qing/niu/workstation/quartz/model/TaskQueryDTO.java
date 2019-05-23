package com.qing.niu.workstation.quartz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
@Getter
@Setter
@ToString
public class TaskQueryDTO implements Serializable{
    private static final long serialVersionUID = -1761145689073654426L;

    private String taskName;

    private String taskGroup;

    private String traceLogId;
}
