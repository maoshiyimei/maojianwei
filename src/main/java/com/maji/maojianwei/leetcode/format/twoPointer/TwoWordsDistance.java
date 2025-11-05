package com.maji.maojianwei.leetcode.format.twoPointer;

/**一个单词数组，找到其中两个单词的最短距离
 *
 * @Author maojianwei
 * @Date 2020/8/11 17:27
 **/
public class TwoWordsDistance {

    /* 双指针， 分别指向两个单词的索引，距离不断更新，初始化使用数组长度可以借鉴 */
    public int findClosest(String[] words, String word1, String word2) {
        int ans = words.length;
        int p1 = words.length, p2 = words.length;
        for (int i = 0;i < words.length;i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                ans = Math.min(ans, Math.abs(p1 - p2));
                if (ans == 1) return 1;
            } else if (words[i].equals(word2)) {
                p2 = i;
                ans = Math.min(ans, Math.abs(p1 - p2));
                if (ans == 1) return 1;
            }
        }

        return ans;
    }
}
