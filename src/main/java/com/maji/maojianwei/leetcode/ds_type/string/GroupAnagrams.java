package com.maji.maojianwei.leetcode.ds_type.string;

import java.util.*;

/**
 * 49. 字母异位词分组
 */

public class GroupAnagrams {
    //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

    /**
     * hashmap: 排序后相同，
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs ) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String orderStr = new String(charArray);
            List<String> list = map.getOrDefault(orderStr, new ArrayList<>());
            list.add(str);
            map.put(orderStr, list);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 可以通过统计每个字符串各个字符出现的次数来判断是不是异位词：当字符串长度很长的时候时间复杂可以改善
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] letterCount = new int[26];
            for(int i = 0 ; i < str.length(); i++) {
                letterCount[str.charAt(i)-'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0 ; i < 26; i++) {
                sb.append(((char)('a' + i)));
                sb.append(letterCount[i]);
            }

            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }


}
