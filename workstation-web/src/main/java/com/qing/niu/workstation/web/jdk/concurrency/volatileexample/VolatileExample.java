package com.qing.niu.workstation.web.jdk.concurrency.volatileexample;

/**
 * <p>
 *
 *     解决cup缓存不一致
 *     1、总线(数据总线、地址总线、控制总线)加锁
 *     2、CPU高速缓存一致性协议 MESI
 *
 *     volatile关键字：
 *     1、保证重排序的时候不会把后面的指令放到屏障的前面，也不会把前面的放到后面
 *     2、强制对缓存的修改操作立刻写入主存
 *     3、如果是写操作，它会导致其他cpu的缓存失效
 *
 *     使用场景：
 *     1、状态量标记 volatile boolean start = true
 *     2、保证屏障前后的一致性：double check方式单例模式
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/12 0:51
 * @ProjectName communication
 * @Version 1.0.0
 */
public class VolatileExample {

    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while(localValue < MAX_LIMIT){
                if (localValue != INIT_VALUE){
                    System.out.printf("The value updated to [%d]\n",INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        },"READER").start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT){
                System.out.printf("update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        },"UPDATER").start();
    }
}
