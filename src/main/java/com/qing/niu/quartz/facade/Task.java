package com.qing.niu.quartz.facade;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
public interface Task {

    /**
     * 任务执行函数
     * @param params     任务参数
     * @param traceLogId 日志ID
     */
    void run(String params,String traceLogId);
}
