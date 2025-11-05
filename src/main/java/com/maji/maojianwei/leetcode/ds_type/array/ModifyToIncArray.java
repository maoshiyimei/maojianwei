package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * Class:给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 即改变一个元素使之称为非严格递增的数组
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/20 , 18:00
 */
public class ModifyToIncArray {
    public static void main(String[] args){
        int[] array = {2,3,3,2,4};
        System.out.println( modifyArray(array) );
    }
    /* 思路是 先找出最长子序列的个数，如果个数小于 n- 1 则不能满足要求  */
    public static boolean modifyArray(int[] array){
        int n = lis(array);
        return n >= array.length -1 ? true : false;

    }
    public static int lis(int[] array){
        int n = array.length;
        int[] record = new int[n];
        record[0] = 1;
        int max = 0;
        for( int i = 1 ; i< n ; i++ ){
            int num = 0;
            int index = -1;
            for( int j = i-1; j >= 0; j-- ){
                if(array[j] <= array[i]){
                    if( record[j] + 1  > num ) {
                        num = record[j] + 1;
                        index = j;
                    }
                }
            }
            record[i] = index == -1 ?  1: num;
            max = record[i] > max ? record[i] : max;
        }
        return max;

    }

    /*上述时间复杂度较高，性能较差，可以优化 */
    public static boolean modifyArray2(int[] nums){
        int count=0;
        for(int i=0; i<nums.length-1; i++)
        {
            if(nums[i]>nums[i+1])
            {
                if(count==1)
                {
                    return false;
                }
                if(i==0)
                {
                    nums[i]=nums[i+1]-1;
                    count++;
                    continue;
                }
                if(nums[i-1] < nums[i+1] )
                {
                    count++;
                    nums[i]=nums[i-1];
                }else{
                    count++;
                    nums[i+1]=nums[i];
                }
            }
        }
        return true;
    }




}
