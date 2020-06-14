package com.qing.niu.workstation.web.jdk.concurrency.volatileexample;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/12 21:51
 * @ProjectName communication
 * @Version 1.0.0
 */
public class VolatileExample2 {

    private static boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while (!initFlag){
            }
            System.out.println("======================");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> {
            prepareData();
        }).start();
    }

    public static void prepareData(){
        System.out.println("preparing data...");
        initFlag = true;
        System.out.println("preparing data end...");
    }
}
