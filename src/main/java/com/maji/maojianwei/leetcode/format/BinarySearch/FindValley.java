package com.maji.maojianwei.leetcode.format.BinarySearch;

/**
 * 形如V形的数组， 不存在重复的数字
 */
public class FindValley {

    /**
     * 二分查找
     * @param array
     * @return
     */
    public static int find(int[] array){
        if(array == null || array.length == 1){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = (left + right )/2;
            //降坡则逢底一定在右边, 升破一定在左边
            if(array[mid] > array[mid+1]){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return array[left];

    }

}

