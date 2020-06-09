package com.qing.niu.workstation.web.jdk.concurrency.api;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/6 22:28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Interrupt {

    public static Object monitor = new Object();

    public static void main(String[] args) throws Exception{
//        Thread t = new Thread(){
//
//            @Override
//            public void run(){
//                while (true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        System.out.println("收到中断信号");
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        };
//
//        t.start();
//        Thread.sleep(1000);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());

//        Thread t = new Thread(){
//
//            @Override
//            public void run(){
//                while (true){
//                    try {
//                        synchronized (monitor){
//                            monitor.wait();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        t.start();
//        Thread.sleep(1000);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());

        Thread t = new Thread(() -> {
           while (true){

           }
        });
        t.setDaemon(true);
        t.start();
        Thread main = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
        });

        t1.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println("收到中断异常");
        }
    }
}
