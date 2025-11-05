package com.maji.maojianwei.leetcode.ds_type.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class HigherTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i< temperatures.length; i++){
            // 注意要保证严格的单调递减栈
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int peekIdx = stack.pop();
                res[peekIdx] = i - peekIdx;
            }
            stack.push(i);
        }

        return res;


    }
}
