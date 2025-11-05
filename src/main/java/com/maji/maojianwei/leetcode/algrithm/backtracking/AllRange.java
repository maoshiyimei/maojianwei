package com.maji.maojianwei.leetcode.algrithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllRange {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfsRange(nums, 0);
        return res;


    }
    public void dfsRange(int[] nums, int idx){
        // 递归出口
        if (idx == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for( int i = idx; i < nums.length; i++) {
            // 交换
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            dfsRange(nums, idx+1);

            // 交换恢复
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }


    }
}
