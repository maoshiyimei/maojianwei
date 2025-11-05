package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

/**
 * 20. 有效的括号
 * 提示
 * 简单
 * 4.3K
 * 相关企业
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class KuohaoIllegal {

    /**
     * 错误解法： 因为（【）】也是非法的， 这里仅考虑到了三种括号zi'sheng
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int smallLeft = 0;
        int smallRight = 0;
        int middleLeft = 0;
        int middleRight = 0;
        int largeLeft = 0;
        int largeRight = 0;

        for(char ch : chars) {
            if(ch == '('){
                smallLeft++;
            } else if (ch == ')' ){
                smallRight++;
                if (smallRight > smallLeft){
                    return false;
                }
            } else if (ch == '['){
                middleLeft++;
            } else if(ch ==']'){
                middleRight++;
                if(middleRight > middleLeft){
                    return false;
                }
            } else if(ch == '{'){
                largeLeft++;
            } else if (ch =='}'){
                largeRight++;
                if (largeRight > largeLeft) {
                    return false;
                }
            }
        }
        return smallLeft == smallRight && middleRight == middleLeft && largeRight == largeLeft;
    }


    /**
     * 基于栈 ，成对即消，最后栈中为空
     * @param s
     * @return
     */

    public boolean isValid2(String s){
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : chars){
            if (ch == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            } else if( ch == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            } else if( ch == '}'){
                if (stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

}
