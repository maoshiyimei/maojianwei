package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47
 * desc: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class AllRangeAllowRepeat {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm, vis);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm, boolean[] vis) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            // 剪枝的结果是：每次都会从连续的重复数字中选第一个，其余不会参与交换
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm, vis);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
