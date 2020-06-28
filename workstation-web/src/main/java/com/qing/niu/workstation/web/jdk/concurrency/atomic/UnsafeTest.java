package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/27 14:53
 * @ProjectName communication
 * @Version 1.0.0
 */
public class UnsafeTest {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {
//        Unsafe unsafe = Unsafe.getUnsafe();
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);

        /**
         * SimpleCounter
         * Counter result:9945588
         * Time passed in 362 ms
         *
         * SynCouter
         * Counter result:10000000
         * Time passed in 1994 ms
         *
         * LockCouter
         * Counter result:10000000
         * Time passed in 629 ms
         *
         * AtomicCouter
         * Counter result:10000000
         * Time passed in 700 ms
         *
         * CasCouter
         * Counter result:10000000
         * Time passed in 769 ms
         */
        ExecutorService service = Executors.newFixedThreadPool(1000);
        Counter counter = new CasCouter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++){
            service.submit(new CounterRunnable(counter,10000));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("Counter result:" + counter.getCounter());
        System.out.println("Time passed in " + (end - start) + " ms");
    }

    public static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    interface Counter{

        void increment();

        long getCounter();
    }

    static class SimpleCouter implements Counter{

        private long counter = 0;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class SynCouter implements Counter{

        private long counter = 0;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class LockCouter implements Counter{

        private long counter = 0;

        private final Lock lock = new ReentrantLock();

        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class AtomicCouter implements Counter{

        private AtomicLong counter = new AtomicLong();

        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }

    static class CasCouter implements Counter{

        private volatile long counter = 0;

        private Unsafe unsafe;

        private long offset;

        CasCouter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CasCouter.class.getDeclaredField("counter"));
        }

        @Override
        public void increment() {
            long current = counter;
            while(!unsafe.compareAndSwapLong(this,offset,current,current + 1)){
                current=counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    static class CounterRunnable implements Runnable{
        private final Counter counter;

        private final int num;

        public CounterRunnable(Counter counter, int num){
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++){
                counter.increment();;
            }
        }
    }
}
