package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39
 * desc: 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * 当然设置条件：这个conditates 是大于等于1的，不会等于0
 */
public class CombinationSum {

    /**
     * 回溯法： 先排序， 然后逐一选取
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(candidates, target, combination, res);
        return res;
    }


    public void findCombination(int[] candidates, int target, List<Integer> combination, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        int cur = combination.isEmpty()? -1 : combination.get(combination.size()-1);
        for(int i = 0 ;i< candidates.length; i++){
            if(candidates[i] < cur){  // 以后选择不会选择比当前小的，否则会重复
                continue;
            }
            if(candidates[i] > target){ // 剪枝
                break;
            }
            combination.add(candidates[i]);
            findCombination(candidates, target- candidates[i], combination, res);
            combination.remove(combination.size()-1);
        }
    }

    /**
     * 无需排序直接回溯：每一个直接选择区或者不取， 当然如果排序的话可以起到提效的作用
     * @param num
     * @param target
     * @return
     */
    public static List<List<Integer>> getCombination(int[] num, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(num, 0, target, combination, res);
        return res;
    }

    public static void backtracking(int[] num, int index, int target, List<Integer> combination, List<List<Integer>> res){

        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(index == num.length){
            return;
        }
        // 不取
        backtracking(num, index +1, target, combination, res);
        combination.add(num[index]);
        //取
        backtracking(num, index+1,target-num[index], combination, res );
        combination.remove(combination.size()-1);
    }


}
