package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 46:
 * desc: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class AllRange3 {

    public static List<List<Integer>> permute(int[] num){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        backtracking(num, 0,  visited, cur, res);
        return res;
    }

    public static void backtracking(int[] num, int index, boolean[] visited, List<Integer> perm, List<List<Integer>> res){
        // 递归出口：不需要创建cur列表，因为数组是现成的
        if(index == num.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0 ; i< num.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            perm.add(num[i]);

            backtracking(num, index+1, visited, perm, res);

            perm.remove(perm.size()-1);
            visited[i] = false;
        }
    }







}
