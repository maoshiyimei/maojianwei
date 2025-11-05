package com.maji.maojianwei.leetcode.format.dp;

/**
 * 512
 * desc: 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 不能返回0
 */
public class ChangeMoney2 {

    /**
     * 方法1： 动态规划： dp[i][j]表示使用i种面额组合金额j的方案数



    /***
     * 使用 i 种货币， 支付 j 元， 解为：使用 i-1 种货币（没用到第i种货币）支付 j 元的方法 + 使用 i 种货币（必须使用到第i货币）支付 j 元的情况，
     * 这样就不会重复
     * 怎样保证使用了呢，当金额小于币种面值，无法使用 = 0
     * 当金额刚好等于币种： = 1
     * 当大于  = （j-币种金额） 的情况，至少使用一次，所以满足
     * 小结： 不使用  + 至少使用一次的
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int getSolutions(int[] coins, int amount){
        // 注意这里币种不需要由小到大， 无序也是正确的！！
        int[][] record = new int[coins.length + 1][amount + 1];
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j<= amount; j++){
                if(j < coins[i-1]){
                    record[i][j] = record[i-1][j];
                } else if( j == coins[i-1]){
                    record[i][j] = record[i-1][j] + 1;
                } else{
                    record[i][j] = record[i-1][j] + record[i][j - coins[i-1]];
                }
            }
        }
        return record[coins.length][amount];
    }


    /**
     * 方法2： 动态规划的优化， 空间的优化, 不过这样没有那么好理解了
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1; // 初始化
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];  // 其实相当于dp[i][j] = dp[i-1][j] + 0 或者 1 或 dp[i][j-coins[i], 实际上 dp[i][j-coins[i] 在一唯数组中等于 dp[i-1][j-coins[i]
            }
        }
        return dp[amount];
    }

}
