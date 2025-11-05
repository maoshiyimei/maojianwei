package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * Class: 动态规划解决 01背包问题
 * 最优解特征：在面对某个元素时要不要取取决与背包的容量和之前的最后解；
 * 解的组织形式： maxV[i][j] 表示面对元素i, 容量为 j 时的 最高价值；
 * 当 w[i] > j  , maxV[i][j] =  maxV[i-1][j];
 * 当 w[i] < j  , maxV[i][j] =  max {maxV[i-1][j] , max[i][ j-w[i] ] + v[i] };
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 16:31
 */
public class DP_3_01Package {
    public static void main(String[] args){
        int[] w = {3, 2, 4, 1, 2, 5, 2};
        int[] v = {2, 3, 3, 2, 5, 4, 3};
        int c = 15;
        /* 注意： 0 边界是在应对第一个不拿的情况下的初始值，因为 maxV 从 1-n ,响应的 在获取 w 和 v 时需要注意序号减1 */
        int n = w.length;
        int[][] maxV = new int[n+1][c+1];
        for( int i = 0 ;i <= n ;i ++){
            Arrays.fill( maxV[i], 0);
        }
        for(int i = 1 ; i <= n ; i++ ){
            for(int j = 1 ; j <= c ; j++ ){
                if(w[i-1] > j ){
                    maxV[i][j] = maxV[i-1][j];
                }
                else{
                    maxV[i][j] = Math.max( maxV[i-1][j] , maxV[i-1][j-w[i-1]] + v[i-1] );
                }
            }
        }
        System.out.println("max value : " +  maxV[n][c]);
        print(maxV);
    }
    public static void print(int[][] array){
        for(int i = 0 ; i < array.length; i ++){
            for(int j = 0 ; j< array[0].length; j++){
                System.out.printf("%6d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
