package com.qing.niu.workstation.web.jdk.concurrency.MutithreadWait;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/6 12:42
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Result {

    private int[] data;

    public Result(int size){
        data = new int[size];
    }

    public void setData(int position, int value){
        data[position] = value;
    }

    public int[] getData(){
        return data;
    }
}
