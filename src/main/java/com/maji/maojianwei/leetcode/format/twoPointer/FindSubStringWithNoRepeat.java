package com.maji.maojianwei.leetcode.format.twoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @Author maojianwei
 * @Date 2020/8/13 13:51
 **/
public class FindSubStringWithNoRepeat {

    /*双指针法：同向，一个遍历，一个指向最左边开始的位置，借助哈希保存元素和位置
    * 如果元素存在，判断是否上次出现位置在开始位置之后，
    * 如果之后，则需要更新开始位置，并更新当前最大值*/
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int maxLength = 0;
        Map<Character, Integer> chMap = new HashMap<>();
        int left = 0;
        for(int i = 0; i < array.length; i++) {
            if (!chMap.containsKey(array[i])) {
                chMap.put(array[i], i);
            }
            else {
                // 更新最大长度
                maxLength = Math.max(maxLength, i-left);
                // map中去调重复元素之前的字符（实际上也可以不用去， 因为已经知道left范围了）
                int cutIdx = chMap.get(array[i]);
                while( left <= cutIdx ){
                    chMap.remove(array[left]);
                    left++;
                }
                chMap.put(array[i], i);
            }
        }
        // 循环后还需要看看(这里是容易出错的地方最好，最好再循环中判断好
        maxLength = Math.max(maxLength, chMap.size());
        return maxLength;

    }

    /**
     * 双指针 + 哈希 优化
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        char[] array = s.toCharArray();
        int maxLength = 0;
        Map<Character, Integer> chMap = new HashMap<>();
        int left = 0;
        for(int i = 0; i < array.length; i++) {
            if (chMap.containsKey(array[i])){
                // 这个条件不可缺少， 因为没有删除数据所以要排除干扰
                if (left <= chMap.get(array[i])) {
                    left = chMap.get(array[i]) + 1;
                }

            }
            chMap.put(array[i], i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

    /* 双指针 优化，当然本质没啥区别*/
    public static int lengthOfLongestSubstring3(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int temp = 0;
        char[] ch = s.toCharArray();
        for(int i =0; i< ch.length;i++){
            if(map.containsKey(ch[i])){
                left = Math.max(left,map.get(ch[i])+1);
            }
            temp = Math.max(temp,i-left+1);
            map.put(ch[i],i);
        }
        return temp;
    }


    public  static String findLongestSubString(String s){
        int[] index = new int[26];
        Arrays.fill(index, -1);

        int maxLength = 0;
        String maxSubStr = "";
        char[] letters = s.toCharArray();
        int start = 0;
        int end = 0;
        while(end < letters.length){
            //没有出现过
            if(index[letters[end] - 'a'] == -1){
                if(end - start +1 > maxLength){
                    maxLength = end -start +1;
                    maxSubStr = s.substring(start, end+1);
                }
            } else {
                //出现过且在起始位置后面需要更新起始位置
                if(index[letters[end] - 'a'] >= start){
                    start =index[letters[end] -'a'] + 1;
                }
            }
            //更新索引
            index[letters[end] - 'a'] = end;
            end++;
        }
        return maxSubStr;
    }

}
