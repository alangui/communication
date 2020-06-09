package com.qing.niu.workstation.web.jdk.concurrency.produceandconsumer;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/7 18:17
 * @ProjectName communication
 * @Version 1.0.0
 */
@SuppressWarnings("Duplicates")
public class Version1 {

    private int i = 0;

    final Object LOCK = new Object();

    private volatile boolean isProduce = false;

    public void produce(){
        synchronized (LOCK){
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                }
            } else {
                i++;
                System.out.println("p -> " + i);
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consumer(){
        synchronized (LOCK){
            if (isProduce){
                System.out.println("C -> " + i);
                LOCK.notify();
                isProduce = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Version1 version1 = new Version1();
        new Thread(() -> {
            while (true){
                version1.produce();
            }
        }).start();

        new Thread(() -> {
            while (true){
                version1.consumer();
            }
        }).start();
    }
}
