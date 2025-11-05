package com.maji.maojianwei.leetcode.format.BinarySearch;

/**
 * 递增有序数组的旋转数组，找到间断点位置
 * 6，7，9， 2，4  -> 2
 */
public class FindBreak {

    /**
     * 二分查找： 利用形状特性，
     * @param array
     * @return
     */
    public static int find(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        if(array.length < 3){
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(array[mid] > array[left]){
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
