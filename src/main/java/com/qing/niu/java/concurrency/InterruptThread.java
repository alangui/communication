package com.qing.niu.java.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/1/2
 */
public class InterruptThread extends Thread {

    private static Logger logger = LoggerFactory.getLogger(InterruptThread.class);

    @Override
    public void run() {
        long number = 1L;
        while(true){
            if (isPrime(number)){
                logger.info("number {} is prime",number);
            }
//            if (isInterrupted()){
//                logger.info("the prime generator has been interrupt");
//                break;
//            }
            number++;
        }
    }

    private boolean isPrime(long number){
        if (number <= 2){
            return true;
        }
        for (long i = 2; i < number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread task = new InterruptThread();
        task.start();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            logger.warn("main thread wake up");
        }
        task.interrupt();
    }
}
