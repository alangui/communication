package com.qing.niu.workstation.web.jdk.concurrency.phaser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/12 12:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class FileSearch implements Runnable{

    private Logger logger = LoggerFactory.getLogger(FileSearch.class);

    private String initPath;

    private String end;

    private List<String> results;

    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser){
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        this.results = new ArrayList<>();
    }

    private void directoryProcess(File file){
        File[] list = file.listFiles();
        if (null == list){
            for (int i = 0; i < list.length; i++){
                if (list[i].isDirectory()){
                    directoryProcess(list[i]);
                }else {
                    fileProcess(list[i]);
                }
            }
        }
    }

    private void fileProcess(File file){
        if (file.getName().endsWith(end)){
            results.add(file.getAbsolutePath());
        }
    }

    private void filterResults(){
        List<String> newResults = new ArrayList<>();
        long actualDate = System.currentTimeMillis();
        for (int i = 0; i < results.size(); i++){
            File file = new File(results.get(i));
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1,TimeUnit.DAYS)){
                newResults.add(results.get(i));
            }
        }
        results = newResults;
    }

    private boolean checkResults(){
        if (results.isEmpty()){
            logger.info("{}: phase {}: 0 results",Thread.currentThread().getName(),phaser.getPhase());
            phaser.arriveAndDeregister();
            return false;
        }else {
            logger.info("{}: phase:{}: {} results",Thread.currentThread().getName(),phaser.getPhase(),results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo(){
        for (int i = 0; i < results.size(); i++){
            File file = new File(results.get(i));
            logger.info("{}: {}",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        logger.info("{} starting...",Thread.currentThread().getName());
        File file = new File(initPath);
        if (file.isDirectory()){
            directoryProcess(file);
        }
        if (!checkResults()){
            return;
        }
        filterResults();
        if (!checkResults()){
            return;
        }
        showInfo();
        phaser.arriveAndDeregister();
        logger.info("{} work complete",Thread.currentThread().getName());
    }
}
