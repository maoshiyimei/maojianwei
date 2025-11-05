package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class: 给定字符串，删除重复相邻的字符，删除后如果有新的可以删除一直循环，最后输出字符串
 * example: abbaca -> ca
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/31 , 20:07
 */
public class Stack_3_RemoveRepeation {
    public static String S = "abbaca";
    public static void main(String[] args){
        System.out.println( deleteRepleationByStack( S ));
        System.out.println( deleteRepleationByString( S ));
    }
    public static String deleteRepleationByStack(String S ){
        char[] chars = S.toCharArray();
        Stack<Character> letters = new Stack<>();
        for(int i = 0 ;i < chars.length ; i++ ){
            if(!letters.isEmpty() && chars[i] == letters.peek() ){
                letters.pop();
            }
            else {
                letters.push(chars[i]);
            }
        }
        StringBuilder result= new StringBuilder();
        while( !letters.isEmpty() ){
            result.append( letters.pop() );
        }
        return result.reverse().toString();
    }

    /* 使用字符串原位操作，借助两个指针，较之栈效率更高 */
    public static String deleteRepleationByString(String S) {
        int n = S.length();
        char[] letters = S.toCharArray();
        int j = 0;
        for( int i =0 ; i < n ; i++, j++){
            letters[j] = letters[i];
            if (j != 0 && letters[j] == letters[j-1]) {
                j -= 2;
            }
        }
        return new String(letters, 0, j);
    }
}
