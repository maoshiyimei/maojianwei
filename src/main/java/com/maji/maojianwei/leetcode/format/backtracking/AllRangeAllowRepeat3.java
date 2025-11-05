package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.*;

/**
 * 47
 * desc: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class AllRangeAllowRepeat3 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        backtrack(nums, map, ans, perm);
        return ans;
    }

    public static void backtrack(int[] nums, Map<Integer, Integer> map, List<List<Integer>> res, List<Integer> perm) {
        if(map.isEmpty()){
            res.add(new ArrayList<>(perm));
            return;
        }
        Iterator iterator =  map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();

            perm.add(entry.getKey());
            map.put(entry.getKey(), entry.getValue() -1);
            if(map.get(entry.getKey()) == 0){
                iterator.remove();
            }
            backtrack(nums, map, res, perm);
            map.put(entry.getKey(), entry.getValue());
        }
    }

}
