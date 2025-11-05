package com.maji.maojianwei.leetcode.format.dp;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutLine {

    /**
     * dp[I] 表示长度为i的线段的最优解
     * 动态规划： 对于每个长度i来讲，内循环中需要考虑j*(i-j)是因为， 按题意至少建成两端，前面的j可以不减，也可以剪，对应的乘积是不同的
     * 时间为O（n2）;
     */
    public static int cuttingRope(int n) {
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for(int i = 2; i<=n; i++){
           for(int j = i-1; j >0 ;j--){
               dp[i] = Math.max(dp[i], Math.max(dp[j] * (i-j), j *(i-j)));
           }
       }
       return dp[n];

    }

    /**
     * 方法2： 利用数学思想尽量平均分即可
     */

    public int cuttingRope2(int n) {
        int result = 0;
        for (int m = 2; m <= n; m++) {
            // 分成 m 段，平均分应该就是最大的。
            // 也就是每个数基本是 n/m，剩下 n%m，给它们加1
            // 会有 n%m 个 (n/m+1)，(m - n%m) 个 n/m
            int multiply = pow(n / m + 1, n % m) * pow(n / m, m - n % m);
            if (multiply > result) {
                result = multiply;
            }
        }
        return result;
    }

    private int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
}
