package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: һ�����������ĳ��ȣ���λ���������Ǯ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:08
 */
public class DP_2_CutRod {
    private static int[] price ={0,
            1,5,8,9,10,17,19,20,24,30,
            35,40,47,50,58,60,69,70,80,85,
            89,90,94,95,100
    };

    public static void main(String[] args) {

        int n =24;
        int best = cutRod(n);
        System.out.println(n+": "+best);
    }
    /*������⣬�ݹ飬 �ظ���������û���Ż� ʱ��Ч�ʽϲ� */
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
}
