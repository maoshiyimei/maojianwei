package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Stack;

/**
 * Class:给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 求在该柱状图中，能够勾勒出来的矩形的最大面积
 * eaample: [2,1,5,6,2,3] - > 10
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/2 , 15:57
 */
public class Stack_5_MaxRectangleArea {
    public static int[] heights = { 2, 1, 5, 6, 2, 3 };
    public static void main(String[] args) {
        System.out.println( calculateMaxRectangleArea( heights ) );
    }
    public static int calculateMaxRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        /* 维持一个递减栈，站内元素对应的值是严格递增的， 元素是序号  */
        Stack<Integer> indexOfIncrease = new Stack<>();
        indexOfIncrease.push(-1);
        for(int i =0 ;i < n ; i++ ) {
            while( indexOfIncrease.peek()!=-1 && heights[ indexOfIncrease.peek() ] >= heights[i] ) {
                int heightOfTop = heights[ indexOfIncrease.pop() ];
                int indexOfSecondTop = indexOfIncrease.peek();
                int maxAreaCurrent =  heightOfTop*(i-1-indexOfSecondTop);
                maxArea = maxAreaCurrent > maxArea ? maxAreaCurrent:maxArea;
            }
            indexOfIncrease.push(i);
        }
        while(indexOfIncrease.peek() != -1 ) {
            int heightOfTop = heights[ indexOfIncrease.pop() ];
            int indexOfSecondTop = indexOfIncrease.peek();
            int maxAreaCurrent =  heightOfTop*(n-1-indexOfSecondTop);
            maxArea = maxAreaCurrent > maxArea ? maxAreaCurrent:maxArea;
        }
        return maxArea;
    }

    /*  也可以使用二分法，先找最矮的，求面积，然后分成左边和右边的子问题，一直迭代即可*/
}
