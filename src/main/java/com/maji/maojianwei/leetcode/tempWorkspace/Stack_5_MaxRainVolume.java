package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/2 , 19:16
 */
public class Stack_5_MaxRainVolume {
    public static int[] heights = {0, 1 , 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    public static void main(String[] args) {
        System.out.println( calculateMaxRainVolume( heights ) );
    }
    /* 使用递增栈，栈内元素是序号， 元素的值递减，如果新的值大于则出栈 */
    public static int calculateMaxRainVolume(int[] heights) {
        int n = heights.length;
        int volume = 0;
        Stack<Integer> indexOfDecrease = new Stack<>();
        for(int i = 0; i < n ; i++) {
            while( !indexOfDecrease.isEmpty() && heights[i] > heights[ indexOfDecrease.peek() ] ){

                int indexOfTop = indexOfDecrease.pop();
                if(indexOfDecrease.isEmpty()){
                    break;
                }
                int indexOfSecondTop = indexOfDecrease.peek();
                int width = i - 1 - indexOfSecondTop;
                int height = heights[i] < heights[ indexOfSecondTop ] ? heights[i] : heights[ indexOfSecondTop ];
                volume += width * ( height- heights[indexOfTop] );
            }
            indexOfDecrease.push(i);
        }
        return volume;
    }
}
