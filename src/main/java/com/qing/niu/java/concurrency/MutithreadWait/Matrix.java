package com.qing.niu.java.concurrency.MutithreadWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/1/6 12:29
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Matrix {

    private Logger logger = LoggerFactory.getLogger(Matrix.class);

    private int[][] matrixData;

    public Matrix(int row, int column, int number){
        matrixData = new int[row][column];
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                matrixData[i][j] = random.nextInt(10);
                if (matrixData[i][j] - number == 0){
                    count++;
                }
            }
        }
        logger.info("the data of matrix is generated,number {} occur count {}",number,count);
    }

    public int[] getRow(int row){
        if (row < 0 || row >= matrixData.length){
            return null;
        }
        return matrixData[row];
    }
}
