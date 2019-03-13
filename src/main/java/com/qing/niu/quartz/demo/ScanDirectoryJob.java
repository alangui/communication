package com.qing.niu.quartz.demo;

import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/12
 */
public class ScanDirectoryJob implements Job{

    private static Logger log = LoggerFactory.getLogger(ScanDirectoryJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String name = jobDetail.getKey().getName();
        String group = jobDetail.getKey().getGroup();
        log.info("jobName:{},jobGroup:{}",name,group);

        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String dirName = jobDataMap.getString("SCAN_DIR");
        if (StringUtils.isBlank(dirName)){
            throw new JobExecutionException("Directory not configured");
        }
        File dir = new File(dirName);
        if (!dir.exists()){
            throw new JobExecutionException("Invalid Directory "+dirName);
        }
        FileFilter filter = new FileExtensionFileFilter(".xml");
        File[] files = dir.listFiles(filter);
        if (files == null || files.length <= 0){
            log.warn("No XML files found in " + dir);
            return;
        }
        int size = files.length;
        for (int i = 0; i < size; i++){
            String msg = files[i].getAbsolutePath() + " - size: " + files[i].length();
            log.info(msg);
        }
    }

    class FileExtensionFileFilter implements FileFilter{

        private String extension;

        public FileExtensionFileFilter(String extension){
            this.extension = extension;
        }

        @Override
        public boolean accept(File pathname) {
            String lowerCaseFileName = pathname.getName().toLowerCase();
            return (pathname.isFile() && (lowerCaseFileName.indexOf(extension) > 0)) ? true : false;
        }
    }

    public static void main(String[] args) throws Exception{
        log.info("----------- Initializing -----------");
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        log.info("----------- Initializing Complete -----------");

        log.info("----------- Schedule Job -------------");
        Date runTime = evenMinuteDate(new Date());
        JobDetail jobDetail = newJob(ScanDirectoryJob.class).withIdentity("job1","group1").build();
        jobDetail.getJobDataMap().put("SCAN_DIR","/java/apache-maven-3.3.9/conf");
        Trigger trigger = newTrigger().withIdentity("trigger1","triggerGroup1").startAt(runTime).build();

        scheduler.scheduleJob(jobDetail,trigger);
        log.info(jobDetail.getKey() + " will run at" + runTime);
        scheduler.start();

        log.info("---------- started schedule ----------");
        log.info("------- waiting 65 seconds ------");
        Thread.sleep(65L * 1000L);

        log.info("--------- shutting down ---------");
        scheduler.shutdown();
        log.info("--------- shutting complete ---------");
    }
}
