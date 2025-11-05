package com.maji.maojianwei.leetcode.algrithm.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 中等
 * 2.2K
 * 相关企业
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubCollection {

    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> curCollection = new ArrayList<>();
        dfs(nums, 0, curCollection);
        return  res;
    }

    public void dfs(int[] nums, int idx, List<Integer> curCol) {
        //递归出口
        if(idx == nums.length){
            res.add(new ArrayList<>(curCol));
            return;
        }

        // 每一个位置， 可以选择加入或者不加入子集

        // 加入
        curCol.add(nums[idx]);
        dfs(nums, idx+1, curCol);
        // 不加入
        curCol.remove(curCol.size()-1);
        dfs(nums, idx+1, curCol);
    }


}
