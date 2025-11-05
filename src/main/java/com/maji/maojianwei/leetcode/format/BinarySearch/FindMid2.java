package com.maji.maojianwei.leetcode.format.BinarySearch;

/**
 * 4
 * desc:给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMid2 {

    /**
     * 方法1： 先归并，整体排序， 然后找出中位数， 时间和空间均是O(n)
     * 如果不合并，而是使用两个指针，虽然空间可以为O（1），但时间是一样的，需要比较所有元素；
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = merge(nums1, nums2);
        int n = newArray.length;
        if( n% 2 != 0){
            return newArray[n/2]*1.0;
        }
        return (newArray[n/2 - 1] + newArray[n/2])/2.0;
    }

    public int[] merge(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m){
            if(array1[i] < array2[j]){
                result[k++] = array1[i++];
            }
            else{
                result[k++] = array2[j++];
            }
        }
        while(i < n){
            result[k++] = array1[i++];
        }
        while(j < m){
            result[k++] = array2[j++];
        }
        return result;
    }


    /**
     * 二分查找： 时间可以到 O( log（m+n）)
     * 相当于找第k小的值
     *
     */
    public static double findMid(int[] array1, int[] array2){
        int num1 = array1.length;
        int num2 = array2.length;
        int totalNum = num1 + num2;
        if( totalNum%2 == 1){
            return getKthValue(array1, 0, num1-1, array2, 0, num2-1, totalNum/2 + 1);
        } else {
            return (getKthValue(array1, 0, num1-1, array2, 0, num2-1, totalNum/2) +
                    getKthValue(array1, 0, num1-1, array2, 0, num2-1, totalNum/2 + 1))/2.0;
        }
    }

    public static int getKthValue(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int k){
        int len1 = end1- start1 +1;
        int len2 = end2- start2 +1;
        if(len1 <=0){
            return array2[start2 + k -1];
        }
        if(len2 <= 0){
            return array1[start1 + k -1];
        }
        if( k == 1){
            return Math.min(array1[start1], array2[start2]);
        }
        int midNum = k/2;
        int compareIndex1 = len1 < midNum ? end1: start1 + midNum -1;
        int compareIndex2 = len2 < midNum ? end2: start2 + midNum -1;
        // 舍弃小的左半部分 利用有序的性质， 可以不用全部遍历
        if(array1[compareIndex1] > array2[compareIndex2]){
            return getKthValue(array1, start1, end1, array2, compareIndex2 + 1, end2, k - (compareIndex2 - start2 +1) );
        } else{
            return getKthValue(array1,compareIndex1 + 1, end1, array2, start2, end2, k - (compareIndex1 - start1 +1) );
        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int leftMidK = (len1 + len2 + 1)/2;
        int rightMidK = (len1 + len2)/2 + 1;
        // 奇数情况下避免重复的查找
        if ((len1 + len2)%2 == 1){
            return getKth(nums1, 0, len1-1, nums2, 0, len2-1, leftMidK);
        } else {
            return (double) (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, leftMidK) +
                    getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, rightMidK)) /2;
        }


    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // 如果一个数组已经为空了直接返回另一个数组的第K个值
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if(len2 == 0) {
            return nums1[start1 + k - 1];
        }
        // 特殊处理， 因为mid == 0 没有什么意义了
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }

        //计算K/2的位置
        int mid =  k/2;
        int nums1MidIdx = Math.min(start1 + mid - 1, end1);
        int nums2MidIdx = Math.min(start2 + mid - 1, end2);
        if( nums1[nums1MidIdx] < nums2[nums2MidIdx]) {
            // 舍弃nums1的前K/2个数(不一定是 k/2个，根据长度而定）
            return getKth(nums1, nums1MidIdx+1, end1, nums2, start2, end2, k - (nums1MidIdx-start1+1));
        } else {
            return getKth(nums1, start1, end1, nums2, nums2MidIdx+1, end2, k - (nums2MidIdx-start2+1));
        }

    }

}
