package com.maji.maojianwei.leetcode.algrithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 中等
 * 3.5K
 * 相关企业
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenKuohao {

    /**
     * 回溯方法
     */
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(new StringBuilder(), 0, 0 , n);

        return res;


    }

    public void dfs(StringBuilder sb, int left, int right, int n){
        if(left == right && left == n) {
            res.add(sb.toString());
            return;
        }
        if( left < n ){
            sb.append("{");
            dfs(sb, left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if( right < left ){
            sb.append("}");
            dfs(sb, left, right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
