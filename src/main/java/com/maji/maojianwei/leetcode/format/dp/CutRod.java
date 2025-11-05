package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * Class: 一根给定铁棒的长度，如何划分卖最多的钱，
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:08
 */
public class CutRod {

    private static int[] r = new int[25];

    private static int[] price ={0,
            1,5,8,9,10,17,19,20,24,30,
            35,40,47,50,58,60,69,70,80,85,
            89,90,94,95,100
    };

    public static void main(String[] args) {

        int n =24;
        Arrays.fill(r, -1);
        int best1 = cutRod(n);
        System.out.println(n+": "+best1);
        int best2 = cutRod2(n);
        System.out.println(n+": "+best2);
        int best3 = cutRod3(n);
        System.out.println(n+": "+best3);

    }
    /**
     * 暴力求解，递归， 重复的子问题没有优化 时间效率较差
     * */
    public static int cutRod(int n) {
        if(n == 0)
            return 0;
        int tempMax = 0;
        for(int i =1 ; i<=n; i++) {
            int temp = price[i]+cutRod(n-i);
            if(temp > tempMax)
                tempMax = temp;
        }
        return tempMax ;
    }

    /**
     * 仍然是递归算法： 递归时会判断子问题是否已经解决了，如果解决了就直接获取，减少计算量，这是自顶向下的方法
     */
    public static int cutRod2(int n) {
        if(r[n]>=0) {
            return r[n];
        }
        if(n==0) {
            return 0;
        }
        else {
            int tempMax = -1;
            for(int i = 1; i <= n; i++) {
                int temp = price[i] + cutRod(n-i);
                if(temp > tempMax )
                    tempMax = temp;
            }
            r[n] = tempMax;
            return tempMax;
        }

    }
    /**
     * 动态规划： 不仅记录子问题最优解，还采取自底向上的方法来实现, 可以避免递归
     * */
    public static int cutRod3(int n) {
        int[] record = new int[n+1];
        Arrays.fill(record, 0);
        for( int i = 1; i <= n ; i++){
            int tempMax = 0;
            for(int j = 1 ; j<= i; j++){
                int temp = price[j] + record[i-j];
                tempMax = tempMax > temp ? tempMax : temp;
            }
            record[i] = tempMax;
        }
        return record[n];
    }

}
