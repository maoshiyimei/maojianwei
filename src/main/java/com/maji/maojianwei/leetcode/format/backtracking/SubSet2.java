package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90
 * desc: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。不包含重复的
 */
public class SubSet2 {

    /**
     * 迭代算法：res 保存结果， lastIncrement 保存上次增加的， 对于重复的元素只增加增量，否则就重复了，
     * 这里先排序，就可以直接利用增量来实现一次遍历，时间复杂度为2^n
     */
    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        List<List<Integer>> lastIncrement = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(lastIncrement.size() == 0 || nums[i] != nums[i-1]){
                lastIncrement.clear();
                int size = res.size();
                for(int j = 0; j<size; j++){
                    List<Integer> tmp = new ArrayList<>(res.get(j));
                    tmp.add(nums[i]);
                    res.add(tmp);
                    lastIncrement.add(new ArrayList<>(tmp));
                }
            }
            else{ // nums[i] == nums[i-1]
                List<List<Integer>> nextIncrement = new ArrayList<>();
                for(List<Integer> set : lastIncrement){
                    set.add(nums[i]);
                    res.add(set);
                    nextIncrement.add(new ArrayList<>(set));
                }
                lastIncrement = nextIncrement;
            }
        }
        return res;
    }

    /**
     * 递归法： 回溯，已有的集合，后面每次递归都加且仅加一个上去，已经加过的就不加相同的。否则就重复
     * 比如1 2 2 3
     * 如果此时temp为 1， 则可以加2 或 3 ，{}、{1}、{1, 2}、{1,3}
     * 但是对于下一个{1,2}，可以加2 或 3 保证不会漏掉，
     */
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        hs(nums, temp, 0);
        return result;
    }

    public static void hs(int[] nums, List<Integer> temp, int index){
        result.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){  //仅仅是每一层不加重复的，之前加过不影响，不会漏掉
                continue;
            }
            temp.add(nums[i]);
            hs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
