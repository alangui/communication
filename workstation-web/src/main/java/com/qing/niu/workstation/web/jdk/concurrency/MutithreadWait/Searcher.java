package com.qing.niu.workstation.web.jdk.concurrency.MutithreadWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/6 14:00
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Searcher implements Runnable{

    private Logger logger = LoggerFactory.getLogger(Searcher.class);
    private int firsrRow;
    private int lastRow;
    private Matrix matrix;
    private Result result;
    private int number;
    private final CyclicBarrier cyclicBarrier;

    public Searcher(int firsrRow, int lastRow, Matrix matrix, Result result, int number, CyclicBarrier cyclicBarrier){
        this.firsrRow = firsrRow;
        this.lastRow = lastRow;
        this.matrix = matrix;
        this.result = result;
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int count = 0;
        logger.info("{} processing lines from {} to {}",Thread.currentThread().getName(),firsrRow,lastRow);
        for (int i = firsrRow; i < lastRow; i++){
            int row[] = matrix.getRow(i);
            if (null == row){
                continue;
            }
            for (int j = 0; j < row.length; j++){
                if (number - row[j] == 0){
                    count++;
                }
            }
        }
        result.setData(firsrRow / 1000,count);
        logger.info("{} lines processed,{},{}",Thread.currentThread().getName(),firsrRow/1000,count);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
