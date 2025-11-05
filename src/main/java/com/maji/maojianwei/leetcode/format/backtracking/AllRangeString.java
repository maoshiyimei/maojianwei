package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.*;

/**
 * 给定字符串，给出所有可能的组合（可能有字符重复）
 *
 */
public class AllRangeString {


    /**
     * 递归：回溯， 注意最后不一定是字典序列， 所以需要最后排序，
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] letters = str.toCharArray();
        // 先排序可以简化剪枝操作，
        Arrays.sort(letters);
        StringBuilder perm = new StringBuilder();
        boolean[] visited = new boolean[str.length()];
        dfs(letters, 0, visited, perm, res);
        Collections.sort(res);
        return res;
    }

    public static void dfs(char[] letters, int k, boolean[] visited, StringBuilder perm, ArrayList<String> res ){
        if( k == letters.length){
            res.add(perm.toString());
        }
        else{
            for( int i = 0; i< letters.length; i++ ){
                //（1）已经访问过
                //（2）如果是重复的数字，只有自己是第一个没有访问过的才会选择，之所以需要考虑之前的是否访问过， 是因为当交换的不是重复数字时候。
                if(visited[i] || (i > 0 && letters[i] == letters[i-1] && !visited[i-1])) {
                    continue;
                }
                perm.append(letters[i]);
                visited[i] = true;

                dfs(letters, k+1, visited, perm, res);

                visited[i] = false;
                perm.deleteCharAt(perm.length()-1);
            }
        }
    }
}
