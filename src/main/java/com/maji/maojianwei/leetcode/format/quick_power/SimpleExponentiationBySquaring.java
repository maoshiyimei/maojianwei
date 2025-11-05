package com.maji.maojianwei.leetcode.format.quick_power;

/**
 * 简单乘方的计算：
 * 使用快速幂：迭代方程式
 * 计算a^n
 *      if n   == 0  -> 1;
 *      if n%2 == 0 -> a^(n/2) * a^(n/2)
 *      if n%2 == 1 -> a^(n-1) * a
 *
 * @author weitong
 * @date 2022/01-17 7:58 下午
 */
public class SimpleExponentiationBySquaring {

    /**
     * 简单计算：N
     */
    public static long calculateContinuous(int a, int n){
        if(n == 0){
            return 1;
        }
        long res = 1;
        for(int i =0 ; i< n ;i++){
            res *= a;
        }
        return res;
    }

    /**
     * 递归计算：logN
     */
    public static long calculate(int a, int n){
        if(n == 0){
            return 1;
        }
        if(n%2 == 1){
            return a * calculate(a, n-1);
        } else {
            long temp = calculate(a, n / 2);
            return temp * temp;
        }
    }
    /**
     * 非递归：logN
     * 从实际运行来看：如果是奇数会最后单独乘一次a,
     */
    public static long calculateNonRer(int a, int n){
        long res = 1;
        while(n != 0){
            if(n%2 == 1){
                res *= a;
                n--;
            } else{
                a *= a;
                n /= 2;
            }
        }
        return res;
    }

}
