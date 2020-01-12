package com.qing.niu.workstation.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/5/24
 */
@Slf4j
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        log.info("定时任务启动...");
    }

    @Scheduled(fixedRate = 10000)
    public void showCurrentTime(){
        log.info("系统当前时间:{}",dateFormat.format(new Date()));
    }
}
