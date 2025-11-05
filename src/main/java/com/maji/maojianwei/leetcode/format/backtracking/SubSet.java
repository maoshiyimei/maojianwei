package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78
 * desc: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class SubSet {

    /**
     * 方法1： 迭代，每次在已有的子集上加入新的元素，原来的也加入，时间复杂度为 1 + 2 + 4 + 8。。。。2^n,
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> set : res){   //如果这里一步完成，使用tmp = new ArrayList<>(res)是错误的，因为List元素依然是List,是引用。
                tmp.add(new ArrayList<>(set));
            }
            for(List<Integer> set : res){
                set.add(num);
            }
            res.addAll(tmp);
        }
        return res;
    }

    /**
     * 方法1 优化：res只要不断增加新的列表即可
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int count=res.size();
            for(int j=0;j<count;j++){
                List<Integer> tmp=new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);  //
            }
        }
        return res;
    }


    /**
     * 方法2： 回溯，每一个num 都有两种选择，时间复杂度依然是2^n
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets3(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> temp){
        if(index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        dfs(nums, index + 1, temp); //不取
        temp.add(nums[index]);
        dfs(nums, index + 1, temp); //取
        temp.remove(temp.size() - 1);
    }


    /**
     * 注意这两中回溯的不同区别，一种是每次两个选择，一种是每次都会选一
     * @param array
     * @return
     */
    public static List<List<Integer>> getSubSet(int[] array){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(array, 0, temp, res);
        return res;
    }

    public static void backTracking(int[] array, int index, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i = index; i< array.length; i++){
            temp.add(array[i]);
            backTracking(array, i+1, temp, res);
            temp.remove(temp.size() -1);
        }
    }

}
