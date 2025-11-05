package com.maji.maojianwei.leetcode.format.dp;

/**
 * 198
 * desc: 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 输入：[1,2,3,1]
 * 输出：4
 */
public class Robbery {
    /**
     * 动态规划：dp[i] 表示在0-i内的最大收获，dp[i] = max{ dp[i-2] + num[i], dp[i-1]}
     * 注意：这里其实也可以不用数组，而只需要两个变量来交替存储即可，空间  O（1）
     */
    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2 ; i< nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /**
     * 使用两个变量即可
     * @param nums
     * @return
     */
    public static int rob2(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        int lastLastSum = nums[0];
        int lastSum = nums[1];
        int max = Math.max(lastLastSum, lastLastSum);
        for(int i = 2; i<nums.length; i++){
            max = Math.max(lastLastSum + nums[i], lastSum);
            lastLastSum = lastSum;
            lastSum = max;
        }
        return max;
    }

    /**
     * 可以进一步简化
     */
    public static int rob3(int[] nums){
        int pre = 0;
        int cur = 0;
        int temp;
        for(int num : nums){
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }


}
