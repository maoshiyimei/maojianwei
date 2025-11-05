package com.maji.maojianwei.leetcode.format.BinarySearch;


/**
 * 35. 搜索插入位置
 * 简单
 * 2.2K
 * 相关企业
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class FindValue {

    public int searchInsert(int[] nums, int target) {
        return findValue(nums, 0, nums.length-1, target);
    }

    public int findValue(int[] nums, int left, int right, int target){
        if (left > right ){
            return left;
        }

        int mid = left +(right-left)/2;

        if (nums[mid] == target){
            return mid;
        }

        if(nums[mid] > target){
            return findValue(nums, left, mid-1, target);
        } else {
            return findValue(nums, mid+1, right, target);
        }
    }

}
