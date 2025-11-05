package com.maji.maojianwei.leetcode.ds_type.array;

/**
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 0 23 3 32 0
 * 0 23 3 32 0 07 0
 *
 * 0 1 0 3 12
 * 1 0 3 12 0
 * 1 3 12 0 0
 *
 */
public class MoveZero {
    /**
     * 错误： 交换已经导致不稳定了！！
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // left -right之间(不包含right) 的数据都是没有判断过的
        int right = nums.length;
        for(int left = 0; left <right && left < nums.length; ) {
            if (nums[left] ==0 ) {
                right--;
                nums[left] = nums[right];
                nums[right] = 0;
            } else {
                left++;
            }
        }
    }

    /**
     * 双指针， 冒泡，
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int right = nums.length-1;
        for( int i = 0 ;i < right; ) {
            if (nums[i] == 0) {
                int j = i;
                while(j < right){
                    nums[j] = nums[j+1];
                    j++;
                }
                nums[right] = 0;
                right--;
            }
            //注意只有非0才能增加
            else {
                i++;
            }
        }
    }

    /**
     * 同侧双指针： 优化效率
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        //
        int p1 = 0;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] == 0 && nums[p2] != 0) {
                nums[p1++] = nums[p2];
                nums[p2++] = 0;
            } else if (nums[p1] == 0 && nums[p2] == 0) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }
    }
}
