package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class:统计棒球分，有四种指令 “数字” “D” 标识上一次分数的两倍，“+” 标识前两次分数的和，“C” 标识上一次的分数无效；清除
 * example:  ["5","2","C","D","+"] 结果为30
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/31 , 19:33
 */
public class Stack_2_BaseballScore {
    public static String[] ops = { "5", "2", "C", "D", "+" };
    public static void main(String[] args) {
        System.out.println( calculateScore(ops) );
    }
    public static int calculateScore(String[] ops) {

        Stack<Integer> scores = new Stack<Integer>();
        for(int i = 0 ; i < ops.length ; i++) {

            if( ops[i].equals("C")  && !scores.isEmpty()) {
                scores.pop();
            }
            else if( ops[i].equals("+") && !scores.isEmpty() ) {
                if(scores.size() < 2 ){
                    scores.push( scores.peek() );
                }
                else{
                    int tempTop = scores.pop();
                    int tempSecond = scores.peek();
                    scores.push( tempTop);
                    scores.push(tempTop + tempSecond );
                }
            }
            else if( ops[i].equals( "D" ) && !scores.isEmpty() ) {
                scores.push( scores.peek()*2);
            }
            else {
                scores.push( Integer.valueOf( ops[i] ) );
            }
        }
        int result =0;
        while(!scores.isEmpty()){
            result += scores.pop();
        }
        return result;

    }

}
