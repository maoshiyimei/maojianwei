package com.maji.maojianwei.leetcode.format.BinarySearch;

/**
 * 类似数组中找到山峰： 1 2 4 3 -> 4
 * 假设一定存在
 */
public class FindOnlyPeak {

    /**
     * 二分查找：
     * 如果上升则封顶在右边
     * 如果下降则封顶在左边
     *
     * @param array
     * @return
     */
    public static int find(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = (left + right) /2;
            if(array[mid] > array[mid+1]){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return array[left];
    }
}
