package com.qing.niu.quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/12
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Logger log = LoggerFactory.getLogger(Main.class);
        log.info("----------- Initializing -----------");
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        log.info("----------- Initializing Complete -----------");

        log.info("----------- Schedule Job -------------");
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        JobDetail jobDetail = JobBuilder.newJob(ScanDirectoryJob.class).withIdentity("job1","group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","triggerGroup1").startAt(runTime).build();

        scheduler.scheduleJob(jobDetail,trigger);
        log.info(jobDetail.getKey() + "will run at" + runTime);
        scheduler.start();

        log.info("---------- started schedule ----------");
        log.info("------- waiting 65 seconds ------");
        Thread.sleep(65L * 1000L);

        log.info("--------- shutting down ---------");
        scheduler.shutdown();
        log.info("--------- shutting complete ---------");
    }
}
