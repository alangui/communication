package com.qing.niu.workstation.web.jdk.concurrency.produceandconsumer;

import java.util.stream.Stream;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/7 18:35
 * @ProjectName communication
 * @Version 1.0.0
 */
@SuppressWarnings("Duplicates")
public class Version2 {

    private int i = 0;

    final Object LOCK = new Object();

    private volatile boolean isProduce = false;

    public void produce(){
        synchronized (LOCK){
            while (isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                }
            }
            i++;
            System.out.println("p -> " + i);
            LOCK.notifyAll();
            isProduce = true;
        }
    }

    public void consumer() {
        synchronized (LOCK) {
            while (!isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("C -> " + i);
            LOCK.notifyAll();
            isProduce = false;
        }
    }

    public static void main(String[] args) {
        Version2 version2 = new Version2();
        Stream.of("P1","P2").forEach(n -> new Thread(() -> {
            while (true){
                version2.produce();
            }
        }).start());

        Stream.of("C1","C2").forEach(n -> new Thread(() -> {
            while (true){
                version2.consumer();
            }
        }).start());
    }
}
