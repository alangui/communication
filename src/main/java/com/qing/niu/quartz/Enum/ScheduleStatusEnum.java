package com.qing.niu.quartz.Enum;

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
public enum ScheduleStatusEnum {

    /**
     * 正常状态
     */
    ACQUIRED("准备运行", "准备运行"),

    /**
     * 运行中
     */
    EXECUTING("EXECUTING", "运行中"),

    /**
     * 完成
     */
    COMPLETE("COMPLETE", "完成"),

    /**
     * 阻塞
     */
    BLOCKED("BLOCKED", "阻塞"),

    /**
     * 线程阻塞状态
     */
    ERROR("ERROR", "错误"),

    /**
     * 线程阻塞状态
     */
    PAUSED("PAUSED", "暂停"),

    /**
     * 线程阻塞状态
     */
    PAUSED_BLOCKED("PAUSED_BLOCKED", "暂停阻塞"),

    /**
     * 线程阻塞状态
     */
    DELETED("DELETED", "删除"),
    ;

    private String code;

    private String msg;
}
