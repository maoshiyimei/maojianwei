package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class: 判断括号是否有效，相同的括号必须成对出现，不考虑优先级,假设只有三种括号；
 * example: {{[{}]}} 是合理的，[{ ] }是不合理的,
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/31 , 21:34
 */
public class Statck_3_BracketJudegment {

    public static String s = "{}()([)]";

    public static void main(String[] args) {
        System.out.println( judgeBracket(s) );
    }
    public static boolean judgeBracket(String s){
        char[] letters = s.toCharArray();
        int n = letters.length;
        Stack<Character> brackets = new Stack<>();
        for(int i =0 ; i < n ; i++){
            if( letters[i] == '{' || letters[i] == '(' || letters[i] == '['){
                brackets.push( letters[i] );
            }
            else if( brackets.isEmpty() ){
                return false;
            }
            else if(  (letters[i] == '}' && brackets.peek() == '{' ) ||
                      (letters[i] == ')' && brackets.peek() == '(' ) ||
                      (letters[i] == ']' && brackets.peek() == '[' ) ){
                brackets.pop();
            }
            else{
                return false;
            }
        }
        return brackets.isEmpty();
    }
}
