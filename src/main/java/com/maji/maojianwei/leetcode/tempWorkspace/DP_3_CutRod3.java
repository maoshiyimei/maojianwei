package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:33
 */
public class DP_3_CutRod3 {
    private static int[] price ={0,
            1,5,8,9,10,17,19,20,24,30,
            35,40,47,50,58,60,69,70,80,85,
            89,90,94,95,100
    };

    public static void main(String[] args) {
        int n =24;
        int best = cutRod(n);
        System.out.println( n + ": " + best);

    }
    /* ������¼���������Ž⣬����ȡ�Ե����ϵķ�����ʵ��, ���Ա���ݹ� */
    public static int cutRod(int n) {
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
