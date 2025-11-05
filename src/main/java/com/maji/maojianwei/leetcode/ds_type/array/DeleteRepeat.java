package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 26
 * desc:  删除排序数组中的重复项, 返回新数组的长度， 希望原地进行， 即空间O（1）
 */
public class DeleteRepeat {

    /**
     * 双指针： 一个遍历比较，一个指向最后一个最终数组位置
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int i = 1;
        int j = 0;
        while( i < nums.length){
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
            i++;
        }
        return j+1;
    }

}
