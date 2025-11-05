package com.maji.maojianwei.leetcode.format.backtracking;


import java.util.*;

/**
 * 46:
 * desc: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class AllRange {

    public static List<int[]> permute(int[] num){
        List<int[]> res = new ArrayList<>();
        backtracking(num, 0, res);
        return res;
    }

    public static void backtracking(int[] num, int index, List<int[]> res){
        // 递归出口：不需要创建cur列表，因为数组是现成的
        if(index == num.length-1){
            int[] cur = new int[num.length];
            for(int i =0; i< cur.length; i++){
                cur[i] = num[i];
            }
            res.add(cur);
            return;
        }
        for(int i = index; i < num.length; i++){
            int temp = num[i];
            num[i] = num[index];
            num[index] = temp;

            backtracking(num, index + 1, res);

            temp = num[i];
            num[i] = num[index];
            num[index] = temp;
        }
    }







}
