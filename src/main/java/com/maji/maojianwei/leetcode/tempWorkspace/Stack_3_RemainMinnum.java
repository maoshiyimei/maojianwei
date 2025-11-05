package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class:给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * example: num = "1432219", k = 3  -> "1219"
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/1 , 20:55
 */
public class Stack_3_RemainMinnum {
    public static String num = "1432219";
    public static void main(String[] args){
        System.out.println( getMinNum(num, 3) );
    }

/* 思路： 左边越小将来的结果越可期，贪心算法， 利用栈 */

    public static String getMinNum(String num, int k){
        char[] nums = num.toCharArray();
        int n =nums.length;
        Stack<Character> remainNum = new Stack<>();
        if( k == n ){
            return "0";
        }
        if( k == 0 ){
            return num;
        }
        int i =0;
        /* 判断是不是需要将该数和左边数进行比较 */
        while( (n-i-1 + remainNum.size() ) >= n-k && i<n){
            if( remainNum.isEmpty() || remainNum.peek() <= nums[i]){
                remainNum.push(nums[i++]);
            }
            else {
                remainNum.pop();
            }
        }
        while( i<n ){
            remainNum.push(nums[i++]);
        }
        while(remainNum.size() > n-k){
            remainNum.pop();
        }
        char[] remainNumsArray = new char[remainNum.size()];
        i=0;
        while(!remainNum.isEmpty()){
            remainNumsArray[i++]=remainNum.pop();
        }
        StringBuilder result = new StringBuilder();
        for(char item: remainNumsArray){
            result.append(item);
        }
        String remainString = result.reverse().toString().replaceFirst("[0]*","");
        return remainString.equals("")? "0" : remainString;
    }

}
