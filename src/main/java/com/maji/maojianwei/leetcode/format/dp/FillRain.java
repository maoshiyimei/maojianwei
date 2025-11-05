package com.maji.maojianwei.leetcode.format.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42
 * desc: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class FillRain {

    /**
     * 栈： 如果递减则入栈， 如果大于则出栈， 注意每次增加的是一层，所以不会累计重复， 即按行加上
     */
    public int trap1(int[] height) {
        int i = 0;
        int vol = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while(i < height.length){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = stack.pop();
                int heightTop = height[top];   //底线，后面计算的体积底线
                if(stack.isEmpty()){  //左边没有边界了， 兜不住
                    break;
                }
                int depth = Math.min(height[i], height[stack.peek()]) - heightTop;  //该层的深度
                int distance = i - stack.peek() - 1;    //相邻的距离没法存贮睡，依据题意
                vol += distance * depth;
            }
            stack.push(i++); // 递减则入栈
        }
        return vol;
    }

    /**
     * 栈： 如果递减则入栈， 如果大于则出栈， 注意每次增加的是一层，所以不会累计重复， 即按行加上
     */
    public int trap7(int[] height) {
       int i = 0;
       int vol = 0;
       Deque<Integer> stack = new ArrayDeque<>();
       while (i < height.length) {
           if (stack.isEmpty() || height[i] < height[stack.peek()]){
               stack.push(i);
           }
           else {
               int idxTop = stack.pop();
               if (!stack.isEmpty()) {
                   vol += ( Math.min(height[stack.peek()], height[i]) - height[idxTop] ) * (i - stack.peek()-1);
               }
           }
       }
       return vol;
    }


    /**
     * 双指针，遍历一次， 那边低就去先处理那边， 处理时拿到记录的最大值，如果当前高度大于最高值则兜不住，更新最高值， 否则，按列加上即可，
     */
    public int trap2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int vol = 0;
        int left_max = 0;   //左边的最大高度
        int right_max = 0;  //右边的最大高度
        while (i < j) {
            if (height[i] < height[j]) {
                if (height[i] >= left_max) {
                    left_max = height[i];   // 兜不住， 更新最大高度
                } else {
                    vol += (left_max - height[i]); // 有坑，水体积为 ( 1 * maxDepth)
                }
                i++;
            } else {
                if (height[j] >= right_max) {
                    right_max = height[j];
                } else {
                    vol += (right_max - height[j]);
                }
                j--;
            }
        }
        return vol;
    }

    /**
     * 双指针： 动态规划优化， left 的leftMax一定是确定的， right 的rightMax一定是确定的
     */
    public int trap8(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int vol = 0;
        while(left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] <= height[right]) {
                vol += leftMax-height[left];
                left++;
            }
            else {
                vol += rightMax-height[right];
                right--;
            }
        }
        return vol;


    }

    /**
     * 动态规划： 和双指针的思想是一样的， 不过空间效率和时间较差。也是按列累加
     */
    public int trap3(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int vol = 0;
        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        right_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        for (int i = n-2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {  //对除了两边的位置，先看最高大左高度和最大右高度，然后取小的，减去本身高度 * 1即为本位置列的可接的水
            vol += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return vol;
    }
    /**
     * 动态规划： 对对于每一列计算可以承接的雨水
     *   vol[i] = 1 * (math.Min(left, right)- height[i)， 所以只需要保存每个位置的边界信息即可，
      */
    public int trap5(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        //保存边界信息(而不是每次都临时去两边查询看，最坏的情况是N2
        for ( int i = 1 ; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for (int i = height.length-2; i>=0 ; i-- ) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        //计算
        int vol = 0;
        for (int i = 0 ; i< height.length; i++) {
            int minBorder = Math.min(leftMax[i], rightMax[i]);
            vol += minBorder - height[i];
        }

        return vol;
    }


}
