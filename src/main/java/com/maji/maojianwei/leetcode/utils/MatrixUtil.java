package com.maji.maojianwei.leetcode.utils;

public class MatrixUtil {

    public static void print(int[][] matrix){
        if(null == matrix){
            return;
        }
        int row = matrix.length;
        System.out.println("************************");
        for(int i = 0 ;i < row; i++){
            ArrayUtil.printArray(matrix[i]);
        }
        System.out.println("************************");
    }


}
