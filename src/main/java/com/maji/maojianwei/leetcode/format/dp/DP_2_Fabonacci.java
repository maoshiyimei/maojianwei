package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class: 斐波那契数列计算，自底向上
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 22:52
 */
public class DP_2_Fabonacci {
    public static void main(String[] args){
        int n = 9;
        System.out.println(n + ": " + fibonacci(n));
    }
    /* 其中的空间只用了两个变量 */
    public static int fibonacci(int n){
        int f0 = 0;
        int f1 = 1;
        if(n==0)
            return f0;
        if(n==1)
            return f1;
        for(int i =2;i<=n;i++) {
            int temp = f0;
            f0 = f1;
            f1 = f1 + temp ;
        }
        return f1;
    }
}
