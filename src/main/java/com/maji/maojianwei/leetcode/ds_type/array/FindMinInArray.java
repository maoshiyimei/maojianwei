package com.maji.maojianwei.leetcode.ds_type.array;


/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 数组中元素唯一，即是严格递增的
 */
public class FindMinInArray {

    /**
     * 二分查找：
     * （1）找到间断点，直接返回
     * （2）判断是在左半支还是右半支上， 通过比较nums[mid] 和 nums[0]
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n ==1 )
            return nums[0];
        int left = 0;
        int right = n-1;
        while (left < right) {
            int mid = left + (right- left)/2;
            if(nums[mid] > nums[mid+1]){  //中断位置找到，有两种情况
                return nums[mid+1];
            }
            if(mid-1 >= 0 && nums[mid-1] > nums[mid]){ //mid-1>=0 ，条件是为了在只有两个元素的时候需要特殊处理
                return nums[mid];
            }
            if(nums[mid] > nums[0]){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }
        return nums[0]; //数组没有动，还是有序的
    }

    /**
     * 优化二分查找的条件, 不在判断间断点，也不和nums[0]比较， 而是和nums[right]比较， 大于等于，则必然在右边， 不包括本身
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[right]) {  //和最右边的比较， 如果大于等于，说明mid在左边， 最小值一定在右边，则left = mid +1
                left = mid + 1;
            } else {
                right = mid;   // 最后left == right, 找到最小值
            }

        }
        return nums[right];

    }

    /**
     *    向右逼到最大值
     */
    public int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {  //和最左边的比较， 如果小于，说明 mid 在右半部分上
                right = mid-1;   //最终的最大值一定是right上
            } else {
                left = mid+1;  // 说明mid在左边，
            }
        }
        return nums[right]; //left>=right, 所以选择right

    }

    /**
     *  找到一个指定的数值， 首先如果左右又一个有序的，看一下是否有必要查看这个部分， 这是确定的，否就另一部分
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right -left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[0]){     // left ～ mid-1是有序的, 这里也可以直接比较nums[mid] & numd[left]
                if(target >= nums[0] && target < nums[mid]){  //说明一定在这一部分或者不存在
                    right =mid-1;
                }
               else{
                   left = mid+1;
               }

            }
            else{  // 说明右边是有序的 mid + 1 ~ right
                if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    /**
     * 如果数据允许重复，即不是严格递增的有序数组进行旋转
     */
    public boolean search2(int[] nums, int target) {
        int n = nums.length;
        if(n==0||nums==null)
            return false;
        int left = 0;
        int right =-1;
        int mid;
        while(left <= right){
            mid=  left + (right-left)/2;
            if(nums[mid]==target)
                return true;
            if(nums[left]==nums[mid]){ // 相同的重复元素直接跳过,这是唯一的区别
                left++;
                continue;
            }
            if(nums[mid] > nums[0]){  //说明  0- mid 有序, 实际上这里也可以判断  nums[mid]& nums[left]
                if(nums[left] <= target && target < nums[mid] ){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{  // 说明 mid - right 是有序的, 先判断一下是否满足要求
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;


    }



}
