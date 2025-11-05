package com.maji.maojianwei.leetcode.ds_type.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class FindAnagrams {


    /**
     * 滑动窗口： 在每个窗口内， 判断是否相同， 依据是每个字符出现的次数是不是相同
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 先处理P的字母出现次数（指纹）
        int[] countP = new int[26];
        for (int i = 0; i < p.length(); i ++) {
            countP[p.charAt(i)-'a']++;
        }
        StringBuilder pFigSb = new StringBuilder();
        for (int i = 0 ; i < 26; i++) {
            pFigSb.append((char)('a' + i));
            pFigSb.append(countP[i]);
        }
        String pFig = pFigSb.toString();

        // 特殊情况处理
        if(s.length() < p.length()) {
            return res;
        }

        int i = 0 ;
        int j = 0 ;
        int[] countS = new int[26];
        while(j < s.length()) {
            countS[s.charAt(j) - 'a']++;
            if (j - i + 1 < p.length()) {
                j++;
                continue;
            }
            // 窗口大小 = length（P）
            else {
                StringBuilder sFigSb = new StringBuilder();
                for (int k = 0 ; k < 26; k++) {
                    sFigSb.append((char)('a' + k));
                    sFigSb.append(countS[k]);
                }
                String sFig = sFigSb.toString();
                if (sFig.equals(pFig)) {
                    res.add(i);
                }
                countS[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return res;
    }


    /**
     * 滑动窗口： 在每个窗口内， 判断是否相同， 依据是每个字符出现的次数是不是相同【优化】直接比较数组大小而不是专程字符串比较， 或者直接将两两字符串作差结果为0也可以
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //初始化（特别处理）
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

}
