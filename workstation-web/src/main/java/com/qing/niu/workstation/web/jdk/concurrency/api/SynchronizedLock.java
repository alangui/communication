package com.qing.niu.workstation.web.jdk.concurrency.api;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/20 16:43
 * @ProjectName communication
 * @Version 1.0.0
 */
public class SynchronizedLock {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(new Thread1(myThread)).start();
        Thread.sleep(1000L);
        new Thread(new Thread2(myThread)).start();
    }
}

class MyThread {

    public synchronized void hello() throws InterruptedException {
        System.out.println("hello");
        Thread.sleep(1000L);
        world();
    }

    public synchronized void world(){
        System.out.println(Thread.currentThread().getName() + ":world");
    }
}

class Thread1 implements Runnable{

    private MyThread myThread;

    public Thread1(MyThread myThread){
        this.myThread = myThread;
    }

    @Override
    public void run() {
        try {
            myThread.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable{

    private MyThread myThread;

    public Thread2(MyThread myThread){
        this.myThread = myThread;
    }

    @Override
    public void run() {
        myThread.world();
        System.out.println("......");
    }
}
