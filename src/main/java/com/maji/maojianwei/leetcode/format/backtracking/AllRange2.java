package com.maji.maojianwei.leetcode.format.backtracking;

import com.maji.maojianwei.leetcode.utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 46: 多此一举！
 * desc: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class AllRange2 {

    public static List<List<Integer>> permute(int[] num){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtracking(num, 0, cur,  res);
        System.out.println(res.size());
        for(List<Integer> list : res){
            ArrayUtil.printArray(list);
        }
        return res;
    }

    public static void backtracking(int[] num, int index, List<Integer> cur,  List<List<Integer>> res){
        // 递归出口：不需要创建cur列表，因为数组是现成的
        if(index == num.length-1){
            cur.add(num[index]);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() -1);
            return;
        }
        for(int i = index; i < num.length; i++){
            int temp = num[i];
            num[i] = num[index];
            num[index] = temp;

            cur.add(num[index]);
            backtracking(num, index + 1, cur, res);
            cur.remove(cur.size()-1);

            temp = num[i];
            num[i] = num[index];
            num[index] = temp;
        }
    }







}
