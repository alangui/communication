package com.qing.niu.workstation.quartz.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.base.Joiner;
import com.google.common.base.Throwables;
import com.qing.niu.workstation.quartz.facade.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
@Slf4j
@Component
public class DubboBeanFactory {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private List<RegistryConfig> registryConfigs;

    private static Map<String,ReferenceConfig<Task>> taskMap = new ConcurrentHashMap<>();

    static {
        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    log.error("休眠中断异常:{}",Throwables.getStackTraceAsString(e));
                }
                log.info("taskMap:{}",Joiner.on(",").join(taskMap.keySet()));
            }
        }).start();
    }

    public Task getService(String taskId){
        try {
            ReferenceConfig<Task> taskRefer = taskMap.get(taskId);
            if (taskRefer != null){
                return taskRefer.get();
            }
            ReferenceConfig<Task> reference = new ReferenceConfig<>();
            reference.setApplication(applicationConfig);
            reference.setRegistries(registryConfigs);
            reference.setRetries(0);
            reference.setInterface(Task.class);
            reference.setTimeout(3000);
            reference.setGroup(taskId);
            reference.setCheck(true);
            Task task = reference.get();
            taskMap.put(taskId,reference);
            return task;
        } catch (Exception e) {
            log.error("获取dubbo服务异常:{}",Throwables.getStackTraceAsString(e));
            throw new IllegalStateException("获取dubbo服务异常");
        }
    }

    public void destroy(String taskId){
        ReferenceConfig referenceConfig = taskMap.remove(taskId);
        if (Objects.nonNull(referenceConfig)){
            log.info("销毁dubbo服务链接:{}",taskId);
            try {
                referenceConfig.destroy();
            } catch (Exception e) {
                log.warn("dubbo服务链接失败！:{}",Throwables.getStackTraceAsString(e));
            }
        }
    }
}
