package com.maji.maojianwei.leetcode.format.BinarySearch;

/**
 * 4
 * desc
 * 有序数组：从中间随意截断，前面放后面，找出中位数比如： 5781234  -> 4
 */
public class FindMid {

    /**
     * 二分查找找到断点的下标，然后就可以知道原来数组是向右移动了位数为 index + 1， 这样原来的中位数相同操作即可
     */

    public static double findMid2(int[] array){
        if(array.length < 3){
            return array[array.length-1];
        }
        int indexLast = findBreakIndex(array);
        int moveSteps = indexLast + 1;
        if(array.length%2 == 1){
            return array[(array.length/2 + moveSteps )%array.length];
        } else{
            int leftMid  = array[((array.length-1)/2  + moveSteps )%array.length];
            int rightMid =array[(array.length/2 + moveSteps )%array.length];
            return (leftMid + rightMid)/2.0;
        }
    }

    /**
     * 找到断点的下标
     * @param array
     * @return
     */
    public static int findBreakIndex(int[] array){
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
