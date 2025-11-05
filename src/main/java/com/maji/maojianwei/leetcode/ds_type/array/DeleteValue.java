package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 27
 * desc: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class DeleteValue {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while(i < j){
            if(nums[i] == val){   //注意 交换后仍有肯能会出现第i位为val, 所以i不自增
                j--;
               nums[i] = nums[j];
               nums[j] = val;
            }
            else{
                i++;
            }
        }
        return i;
    }

}
