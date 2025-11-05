package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:25
 */
public class DP_2_CutRod2 {
    private static int[] price ={0,
            1,5,8,9,10,17,19,20,24,30,
            35,40,47,50,58,60,69,70,80,85,
            89,90,94,95,100
    };
    private static int[] r = new int[25];

    public static void main(String[] args) {
        int n =24;
        Arrays.fill(r, -1);
        int best = cutRod(n);
        System.out.println( n + ": " + best);

    }
    /* �뱩���ⷨ��Ψһ�����ǣ��ݹ�ʱ���ж��������Ƿ��Ѿ�����ˣ��������˾�ֱ�ӻ�ȡ�����ټ������������Զ����µķ��� */
    public static int cutRod(int n) {
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
}
