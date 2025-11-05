package com.maji.maojianwei.leetcode.ds_type.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
 */
public class ReverseSentence {
    /**
     * 逻辑：使用栈来完成
     */
    public String trans(String s, int n) {
        Deque<String> stack = new ArrayDeque<>();
        char[] letters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char letter : letters){
            if(letter == ' '){
                stack.push(sb.toString());
                stack.push(" ");
                sb.delete(0, sb.length());
            }
            else if(letter >= 'A' && letter <= 'Z'){
                sb.append((char)(letter + 32));
            }
            else{
                sb.append((char)(letter - 32));
            }
        }
        if(sb.length() > 0){
            stack.push(sb.toString());
            sb.delete(0, sb.length());
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }
}
