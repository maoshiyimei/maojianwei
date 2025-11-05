package com.maji.maojianwei.leetcode.ds_type.string;

import java.util.Stack;

/**
 * 1047
 * desc:删除字符串中的所有相邻重复项,给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
 * 输入："abbaca"
 * 输出："ca"
 * 注意： 题意中说明没有AAA这样大于两个连续重复，否则下列解法是有问题的。
 */
public class DeleteRepeat {

    /**
     * 使用栈，每次和栈顶元素进行比较
     */
    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> letters = new Stack<>();
        for(int i = 0 ;i< chars.length; i++){
            if(letters.isEmpty() || letters.peek() != chars[i]){
                letters.push(chars[i]);
            } else{
                letters.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!letters.isEmpty()){
            sb.append(letters.pop());
        }
        return sb.reverse().toString();
    }

    /**
     *双指针， 一个指向最终位置，不断更新，  一个指向遍历位置，不断向前
     */
    public static String removeDuplicates2(String S){
        int n = S.length();
        if( n == 1){
            return S;
        }
        char[] letters = S.toCharArray();
        int j = 0;
        for( int i =0 ; i < n ; i++, j++){
            letters[j] = letters[i];
            if (j != 0 && letters[j] == letters[j-1]) {
                j -= 2;  // 两个都不要，指针后退
            }
        }
        System.out.println(j);
        if(j <= 0){
            return "null";
        }
        return new String(letters, 0, j);




    }



}
