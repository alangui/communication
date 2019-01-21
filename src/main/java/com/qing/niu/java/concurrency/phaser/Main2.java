package com.qing.niu.java.concurrency.phaser;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/13 17:19
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        Student[] student = new Student[3];
        for (int i = 0; i < 3; i++){
            student[i] = new Student(phaser);
            phaser.register();
        }
        System.out.printf("phaser %s\n",phaser.getUnarrivedParties());
        Thread[] thread = new Thread[3];
        for (int i = 0; i < 3; i++){
            thread[i] = null;
            try {
                thread[i] = new Thread(student[i],"student-"+i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            thread[i].start();
        }
        try {
            thread[0].join();
            thread[1].join();
            thread[2].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("main has finished,phaser status is %s",phaser.isTerminated());
    }
}
