package com.maji.maojianwei.leetcode.format.dp;

/**
 *746
 * desc:
 *  数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *  每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *  请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class ClimbStairs2 {

    /**
     * 同样是动态规划。并且空间可以常数
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0; // 在某一个阶梯的成本等于前面两个阶梯走到这一步的代价的最小值
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }


    /**
     * 错解：理解错了，cost[0]表示在0上需花费，
     *
     * @param cost
     * @return
     */
    public static int getMinCost(int[] cost){
        int[] record = new int[cost.length];
        record[0] = cost[0];
        record[1] = cost[1];
        for(int i = 2; i<cost.length; i++){
            record[i] = Math.min(record[i-1], record[i-2]) + cost[i];
        }
        return record[cost.length-1];
    }

    public static int getMinCost2(int[] cost){
        int[] record = new int[cost.length];
        record[0] = cost[0];
        record[1] = cost[0];

        for(int i = 2; i< cost.length; i++){
            record[i] = Math.min(cost[i-1] + record[i-1], cost[i-2] + record[i-2]);
        }
        return record[cost.length-1];
    }
}
