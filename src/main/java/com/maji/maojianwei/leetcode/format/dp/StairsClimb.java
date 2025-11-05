package com.maji.maojianwei.leetcode.format.dp;

/**
 * 70
 * desc: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 */
public class StairsClimb {

    /**
     * 等价于斐波那契额数列， f(n) = f(n-1) + f(n-2) , 自下而上计算，时间为）O（n）,
     */
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        if( n <= 1)
            return 1;
        for( int i = 2; i <=n ;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 空间进一步优化
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        int lastSteps = 1;
        int lastLastSteps = 1;
        for(int i = 2; i <=n; i++){
            int temp = lastSteps;
            lastSteps = lastLastSteps + temp;
            lastLastSteps = temp;
        }
        return lastSteps;
    }


}
