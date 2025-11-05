package com.maji.maojianwei.leetcode.format.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author maojianwei
 * @Date 2020/8/10 17:18
 **/
public class ThreeSumToZero {

    /* 先排序，然后一次遍历，后两个数使用双指针，双向，时间复杂度为n2, 注意相邻去重，那些需要使用重复的不会漏掉！*/
    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for( int i = 0 ; i<= n-3; i++){
            if(nums[i]>0)
                break;
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1, k = n-1;j < k ; ){
                int sum = nums[i] + nums[j] + nums[k]; // 保证不会漏掉重复的
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j+1] == nums[j] ){
                        j++;
                    }
                    while(k> j && nums[k-1] == nums[k]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if( sum > 0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }
}
