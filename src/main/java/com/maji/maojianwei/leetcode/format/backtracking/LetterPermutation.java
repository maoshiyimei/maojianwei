package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784
 * desc: 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 输入：S = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 */
public class LetterPermutation {

    /**
     * 回溯法：
     */
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] letters = S.toCharArray();
        dfs(letters, 0, sb, res);
        return res;
    }

    public void dfs(char[] letters, int i, StringBuilder sb, List<String> res){
        if(i == letters.length){
            res.add(sb.toString());
            return;
        }
        //不转换
        sb.append(letters[i]);
        dfs(letters, i+1, sb, res);
        sb.deleteCharAt(sb.length()-1);
        if(letters[i] >= '0' && letters[i] <= '9'){
            return;
        }
        // 转换
        if(letters[i] >= 'a' && letters[i] <= 'z'){
            sb.append((char)(letters[i] - 32));
        }
        else{
            sb.append((char)(letters[i] + 32));
        }
        dfs(letters,i+1, sb, res);
        sb.deleteCharAt(sb.length() -1);
    }

}
