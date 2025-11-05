package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 238. 除自身以外数组的乘积
 * 中等
 * 1.6K
 * 相关企业
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 1 2 3 4
 * 1 1 2 6
 * 24  12  4 1
 */

public class MultiplyArray {

    /**
     * 动态规划: 进一步优化可以直接在res上进行计算省空间，先存储left后面存储right
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // 存储每一个位置左右两边乘机之和的数据
        int[] leftMultiply = new int[nums.length];
        int[] rightMultiply = new int[nums.length];
        leftMultiply[0] = 1;
        rightMultiply[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++){
            leftMultiply[i] = leftMultiply[i-1]*nums[i-1];
        }

        for (int j = nums.length-2; j >=0; j--){
            rightMultiply[j] = rightMultiply[j+1]*nums[j+1];
        }

        int[] res = new int[nums.length];
        for (int i = 0 ; i< nums.length; i++) {
            res[i] = leftMultiply[i] * rightMultiply[i];
        }

        return res;
    }
}
