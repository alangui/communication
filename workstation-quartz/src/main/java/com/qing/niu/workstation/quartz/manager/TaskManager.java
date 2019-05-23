package com.qing.niu.workstation.quartz.manager;

import com.qing.niu.workstation.quartz.mapper.TaskMapper;
import com.qing.niu.workstation.quartz.model.TaskPageQueryDTO;
import com.qing.niu.workstation.quartz.model.TaskQueryDTO;
import com.qing.niu.workstation.quartz.model.TaskResDTO;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
@Component
public class TaskManager {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private TaskMapper taskMapper;

    /**
     * 新增调度作业
     *
     * @param jobName 任务名
     * @param jobGroup 任务组名
     * @param triggerName 作业触发名
     * @param triggerGroup 作业组名
     * @param cronExpression cron表达式
     * @param jobDataMap 作业数据
     * @param misfireInstruction 作业错失触发策略
     * @throws SchedulerException 调度异常
     */
    @SuppressWarnings(value = "Duplicates")
    public void addScheduleJob(String jobName, String jobGroup, String triggerName, String triggerGroup,
                               String cronExpression, Map jobDataMap, Integer misfireInstruction) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(jobName,jobGroup);
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        if (null != misfireInstruction){
            if (misfireInstruction == 1){
                scheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
            }
            if (misfireInstruction ==2 ){
                scheduleBuilder.withMisfireHandlingInstructionDoNothing();
            }
        }
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroup).
                withSchedule(scheduleBuilder).forJob(jobKey).build();
        if (null != jobDataMap && jobDataMap.size() > 0){
            cronTrigger.getJobDataMap().putAll(jobDataMap);
        }
        scheduler.scheduleJob(cronTrigger);
    }

    /**
     * 修改调度作业
     *
     * @param triggerName 作业触发名
     * @param triggerGroup 作业组名
     * @param cronExpression cron表达式
     * @param jobDataMap 作业数据
     * @param misfireInstruction 作业错失触发策略
     * @throws SchedulerException 调度异常
     */
    @SuppressWarnings(value = "Duplicates")
    public void modifyScheduleJob(String triggerName, String triggerGroup, String cronExpression,
                                  Map jobDataMap, Integer misfireInstruction) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroup);
        //获取cron trigger
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        if (null != misfireInstruction){
            if (misfireInstruction == 1){
                cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
            }
            if (misfireInstruction == 2){
                cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
            }
        }
        cronTrigger = cronTrigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
        if (null != jobDataMap && jobDataMap.size() > 0){
            cronTrigger.getJobDataMap().putAll(jobDataMap);
        }
        scheduler.rescheduleJob(triggerKey,cronTrigger);
    }

    /**
     * 删除调度作业
     *
     * @param triggerName 作业名
     * @param triggerGroup 作业组
     * @throws SchedulerException 调度异常
     */
    public void deleteScheduleJob(String triggerName, String triggerGroup) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroup);
        scheduler.unscheduleJob(triggerKey);
    }

    /**
     * 立即触发作业
     *
     * @param triggerName 作业名
     * @param triggerGroup 作业组
     * @throws SchedulerException 调度异常
     */
    public void triggerJob(String triggerName, String triggerGroup) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroup);
        Trigger trigger = scheduler.getTrigger(triggerKey);
        scheduler.triggerJob(trigger.getJobKey(),trigger.getJobDataMap());
    }

    /**
     * 暂停作业
     *
     * @param triggerName 作业名
     * @param triggerGroup 作业组
     * @throws SchedulerException 调度异常
     */
    public void pauseTrigger(String triggerName, String triggerGroup) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroup);
        scheduler.pauseTrigger(triggerKey);
    }

    /**
     * 恢复作业
     *
     * @param triggerName 作业名
     * @param triggerGroup 作业组
     * @throws SchedulerException 调度异常
     */
    public void resumeTrigger(String triggerName, String triggerGroup) throws SchedulerException{
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroup);
        scheduler.resumeTrigger(triggerKey);
    }

    /**
     * 查询调度作业
     *
     * @param taskQueryDTO 请求参数
     * @return 调度作业
     */
    public TaskResDTO selectByTaskName(TaskQueryDTO taskQueryDTO) {
        TaskResDTO taskResDTO = taskMapper.selectByTaskName(taskQueryDTO);
        return taskResDTO;
    }

    /**
     * 查询调度作业总数
     *
     * @param taskPageQueryDTO 请求参数
     * @return 调度作业总数
     */
    public int selectTaskCount(TaskPageQueryDTO taskPageQueryDTO) {
        return taskMapper.selectTaskCount(taskPageQueryDTO);
    }

    /**
     * 调度作业分页查询
     *
     * @param taskPageQueryDTO 分页请求参数
     * @return 分页查询结果
     */
    public List<TaskResDTO> selectTaskPage(TaskPageQueryDTO taskPageQueryDTO) {
        return taskMapper.selectTaskPage(taskPageQueryDTO);
    }
}
