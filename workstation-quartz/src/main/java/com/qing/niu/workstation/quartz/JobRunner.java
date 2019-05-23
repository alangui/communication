package com.qing.niu.workstation.quartz;

import com.qing.niu.workstation.quartz.util.ApplicationContextUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.UUID;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/3/10 16:29
 * @ProjectName communication
 * @Version 1.0.0
 */
@Slf4j
@Setter
public class JobRunner extends QuartzJobBean{

    private boolean concurrent;

    private String taskId;

    private String jobParams;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ApplicationContextUtil.getBean(JobAsyncRunner.class).
                run(taskId,jobParams,concurrent,UUID.randomUUID().toString());
    }
}
