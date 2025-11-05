package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityNum {

    /**
     * 方法1： 直接排序，然后取中点即可
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     *方法2： 借助map
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 方法3： 摩尔投票, 相当于不断抵消最后留下的自然是众数
     */
    public int majorityElement(int[] nums) {
        if(nums.length <=2){
            return nums[0];
        }
        int canditate = nums[0];
        int votes = 1;
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == canditate){
                votes++;
            }
            else{
                votes--;
                if(votes == 0){
                    canditate = nums[i];
                    votes = 1;
                }
            }
        }
        return canditate;
    }

}
