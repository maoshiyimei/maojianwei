package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SampleCombination {

    public static List<List<String>> sampleCombination(List<List<String>> lists) {
        //存放结果
        List<List<String>> res = new ArrayList<>();
        if(lists == null || lists.size() == 0){
            return res;
        }
        // temp 保存遍历中的某一个组合
        List<String> temp = new ArrayList<>();
        sample(lists, 0, temp, res);
        return res;

    }

    public static void sample(List<List<String>> samples, int k, List<String> temp, List<List<String>> res){
        // 递归出口
        if( k == samples.size()){
            // 将此组合加到结果中
            res.add(new ArrayList<>(temp));
            return;
        }
        // 在此层级中选择
        List<String> candidate = samples.get(k);
        for(int i = 0 ; i< candidate.size(); i++){
            // 加入到组合中
            temp.add(candidate.get(i));
            sample(samples, k + 1, temp, res);
            // 从组合中拿掉，然后更换其他值
            temp.remove(temp.size()-1);
        }
    }



}
