package com.maji.maojianwei.leetcode.format.twoPointer;

import java.util.ArrayList;
import java.util.List;

/**字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"

 * @Author maojianwei
 * @Date 2020/8/13 10:39
 **/
public class StringSplit {

    /**
     * 对于每一个位置， 看是否是最后一个，不断更新子串的长度， 两次便利，避免重复判断
     * @param s
     */
    public static void split(String s ){
        System.out.println(s);


        List<String> res = new ArrayList<>();
        int[] lastIdx = new int[26];
        char[] letters = s.toCharArray();
        for(int i = 0 ; i< letters.length; i++){
            lastIdx[letters[i]-'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i<letters.length ;i++){
            end = Math.max(end, lastIdx[letters[i] - 'a']);
            if(end == i){
                res.add(s.substring(start, end+1));
                start = i +1;
                end = start;
            }
        }


        for(String str : res ){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
