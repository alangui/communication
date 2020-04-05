package com.qing.niu.workstation.web.jdk.concurrency.ThreadExceptionCaught;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/5 14:58
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) throws Exception{
        ThreadMonitor threadMonitor = new ThreadMonitor();
        threadMonitor.init();
        for (int i = 0; i < 100; i ++){
            threadMonitor.service("task" + i);
        }
        Thread.sleep(2000);
//        SystemInfo.exit(0);
    }
}
