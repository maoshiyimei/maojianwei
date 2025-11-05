package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * 322
 * desc: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 */
public class ChangeMoney {

    /**
     * 贪心算法, 错误， 因为可能出现因为选择一个较大的面额，然后后面无法兑换的问题；
     */
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        for(int i = coins.length-1; i >=0 && amount >0; i--){
            while(amount >= coins[i]){
                count++;
                amount-=coins[i];
            }
        }
        if(amount != 0){
            return -1;
        }
        else{
            return count;
        }
    }

    /**
     * 动态规划 dp[i] 表示金额 I 需要使用的最小货币数
     */

    public static int getMinChanges(int[] coins, int amount){
        int[] record = new int[amount + 1];
        Arrays.fill(record, Integer.MAX_VALUE);
        record[0] = 0;
        for(int i = 1; i<= amount; i++ ){
            for(int coin : coins){
                if( i - coin >= 0){
                    record[i] = Math.min(record[i], record[i - coin] + 1);
                }
                //如果不足说明没法用这种币种来支付，所以不更新
            }
        }
        return record[amount] <= amount? record[amount]: -1;
    }

}
