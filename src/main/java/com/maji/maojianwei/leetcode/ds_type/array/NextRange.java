package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 31
 * desc: 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class NextRange {

    /**
     * （1）从右到左找到第一个大于左边的位置
     * （2）该位置使用右边大于其值得最小值替代
     * （3）其他位置按从小到大排列即可
     * （4）如果数组是逆序的，直接返回从小到达的顺序即可
     */
    public void nextPermutation(int[] nums) {
        if(nums.length <=1)
            return;
        List<Integer> canditate = new ArrayList<>();
        canditate.add(nums[nums.length-1]);  // 第一个先入队列
        int i = nums.length-2;
        for(;i >= 0; i--){
            if(nums[i] < nums[i+1]){
                break;
            }
            canditate.add(nums[i]);
        }
        Collections.sort(canditate);
        if( i >= 0){
            for(int j = 0 ;j< canditate.size();j++){
                if(canditate.get(j) > nums[i]){ // 这个位置替换的是最小的而是大于nums[i]的最小值，
                    int tmp = nums[i];
                    nums[i] = canditate.get(j);
                    canditate.set(j, tmp);
                    break;
                }
            }
        }
        i++;
        for(int j = 0;i < nums.length; i++){
            nums[i] = canditate.get(j++);
        }

    }

}
