package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class:给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * example: [9,9,6,0,6,6,9] - > 3
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/2 , 21:01
 */
public class Stack_5_LongestGoodPeriod {
    public static int[] hours = {9, 9, 6, 0, 6, 6, 9 };
    public static void main(String[] args) {
        System.out.println( getLongestGoogPeriod(hours) );
    }
    public static int getLongestGoogPeriod(int[] hours) {
        int n = hours.length;
        /* 简化逻辑 用 1 和 -1 替换，问题变成找最长字串（和大于0）  */
        for(int i =0 ; i< n ; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1 ;
        }
        int[] accumulation = new int[n+1];
        accumulation[0] = 0;
        for(int i =1 ;i <= n ; i++){
            accumulation[i] = hours[i-1] + accumulation[i-1];
        }
        /* 递减栈，第一个元素为序号0， 以后记录小于0的序号， */
        Stack<Integer> indexOfDecrease = new Stack<>();
        for(int i = 0; i< n+1 ; i++){
            if(indexOfDecrease.isEmpty() || accumulation[i] < accumulation[ indexOfDecrease.peek() ] ) {
                indexOfDecrease.push(i);
            }
        }
        int result = 0;
        for(int i =n ;i > result ; i-- ) {
            while( !indexOfDecrease.isEmpty() && accumulation[i] > accumulation[ indexOfDecrease.peek() ] ) {
                int periodSpan = i - indexOfDecrease.pop();
                result = periodSpan > result ? periodSpan : result;
            }
        }
        return result;
    }
}
