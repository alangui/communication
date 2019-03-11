package com.qing.niu.quartz.model;

import com.google.common.base.Throwables;
import com.qing.niu.quartz.Enum.ScheduleStatusEnum;
import com.qing.niu.quartz.Enum.TaskStatusEnum;
import com.qing.niu.quartz.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

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
@Slf4j
public class TaskResDTO implements Serializable{
    private static final long serialVersionUID = -8014714318134318495L;

    private String taskName;

    private String taskGroup;

    private String cronExpression;

    private Long preFireTime;

    private Long nextFireTime;

    private String taskStatus;

    private String scheduleStatus;

    private String jobData;

    private String preFireDate;

    private String nextFireDate;

    private String taskStatusDesc;

    private String scheduleStatusDesc = "未运行";

    private String taskId;

    private String jobParams;

    private boolean concurrent;

    public void setPreFireTime(Long preFireTime){
        this.preFireTime = preFireTime;
        if (!Objects.isNull(preFireTime)){
            preFireDate = DateUtil.format(new Date(preFireTime),DateUtil.settlePattern);
        }
    }

    public void setNextFireTime(Long nextFireTime){
        this.nextFireTime = nextFireTime;
        if (!Objects.isNull(nextFireTime)){
            nextFireDate = DateUtil.format(new Date(nextFireTime),DateUtil.settlePattern);
        }
    }

    public void setTaskStatus(String ts){
        taskStatus = ts;
        if(taskStatus == null){
            taskStatusDesc = TaskStatusEnum.NONE.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.DELETED.getCode())) {
            taskStatusDesc =  TaskStatusEnum.NONE.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.COMPLETE.getCode())) {
            taskStatusDesc =  TaskStatusEnum.COMPLETE.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.PAUSED.getCode())) {
            taskStatusDesc = TaskStatusEnum.PAUSED.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.PAUSED_BLOCKED.getCode())) {
            taskStatusDesc = TaskStatusEnum.PAUSED.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.ERROR.getCode())) {
            taskStatusDesc = TaskStatusEnum.ERROR.getMsg();
            return;
        }
        if (taskStatus.equals(ScheduleStatusEnum.BLOCKED.getCode())) {
            taskStatusDesc = TaskStatusEnum.BLOCKED.getMsg();
            return;
        }
        taskStatusDesc =  TaskStatusEnum.NORMAL.getMsg();
    }

    public void setScheduleStatus(String scheduleStatus){
        this.scheduleStatus = scheduleStatus;
        if (!Objects.isNull(scheduleStatus)){
            scheduleStatusDesc = ScheduleStatusEnum.valueOf(scheduleStatus).getMsg();
        }
    }

    public void setJobData(String jobData){
        this.jobData = jobData;
        if (!StringUtils.isBlank(jobData)){
            ByteArrayInputStream bis = null;
            try {
                bis = new ByteArrayInputStream(jobData.getBytes("UTF-8"));
                Properties properties = new Properties();
                properties.load(bis);
                this.taskId = properties.getProperty("taskId");
                this.jobParams = properties.getProperty("jobParams");
                this.concurrent = Boolean.valueOf(properties.getProperty("concurrent"));
            } catch (Exception e) {
                log.error("jobData数据转换出错！{}",Throwables.getStackTraceAsString(e));
            } finally {
                try {
                    bis.close();
                } catch (IOException e) {
                    log.error("字节数组流关闭异常！{}",Throwables.getStackTraceAsString(e));
                }
            }
        }
    }
}
