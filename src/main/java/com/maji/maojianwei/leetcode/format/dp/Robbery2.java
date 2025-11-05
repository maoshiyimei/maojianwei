package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * 213
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。房屋连成一圈，求最大收获
 * 输入：nums = [2,3,2]
 * 输出：3
 */
public class Robbery2 {


    /**
     * 动态规划，将第一个取和不取的分开考虑， 取较大的即可，
     */
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
