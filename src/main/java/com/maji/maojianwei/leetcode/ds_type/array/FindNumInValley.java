package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 形如V形的数组， 不存在重复的数字
 */
public class FindNumInValley {

    public static int findMin(int[] nums){
        int i = 0 ;
        int j = nums.length-1;
        while(i < j ){
            int m = i + (j - i)/2;
            if( nums[m]  < nums[m+1] ){  //升破, 注意这里使用 j = m 而不是 就= m-1， 因为nums[m】可能就是谷底
                j = m;
            }
            else{ //降坡
                i = m + 1;   //这时候不会出现上面的问题，因为nums[m]坑定不是谷底
            }
        }
        return j;
    }

    /**
     * 思路1： 先找到最小下标， 然后两边分别二分查找即可。
     */
    public static int find(int[] nums, int target){
        int minIndex = findMin(nums);
        int res = findNum(nums, 0, minIndex, target);
        if(res != -1){
            return res;
        } else{
            return findNum(nums, minIndex + 1, nums.length-1, target);
        }
    }

    public static int findNum(int[] array, int left, int right, int target){
        if( left > right){
            return -1;
        }
        int mid = (left + right ) /2;

        if(array[mid] == target){
            return mid;
        } else if( array[mid] > target){
            return findNum(array, left, mid-1, target);
        } else{
            return findNum(array, mid+1, right, target);
        }
    }
}

