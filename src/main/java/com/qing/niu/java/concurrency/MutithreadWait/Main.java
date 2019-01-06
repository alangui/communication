package com.qing.niu.java.concurrency.MutithreadWait;

import java.util.concurrent.CyclicBarrier;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/6 14:20
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(10000,1000,5);
        Result result = new Result(10);
        Group group = new Group(result);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10,group);
        int len = 1000;
        for (int i = 0; i < 10; i++){
            Searcher searcher = new Searcher(i*len,(i+1)*len,matrix,result,5,cyclicBarrier);
            new Thread(searcher).start();
        }
        System.out.println("main thread finished");
    }
}
