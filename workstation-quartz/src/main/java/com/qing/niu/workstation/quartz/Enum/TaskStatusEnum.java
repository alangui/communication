package com.qing.niu.workstation.quartz.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    /**
     * Trigger已经完成，且不会在执行，或者找不到该触发器，或者Trigger已经被删除
     */
    NONE("NONE", "删除"),

    /**
     * 正常状态
     */
    NORMAL("NORMAL", "正常"),

    /**
     * 暂停状态
     */
    PAUSED("PAUSED", "暂停"),

    /**
     * 触发器完成，但是任务可能还正在执行中
     */
    COMPLETE("COMPLETE", "运行中"),

    /**
     * 出现错误
     */
    ERROR("ERROR", "错误"),

    /**
     * 线程阻塞状态
     */
    BLOCKED("BLOCKED", "线程阻塞");


    private String code;

    private String msg;

}
