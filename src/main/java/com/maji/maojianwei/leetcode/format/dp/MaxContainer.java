package com.maji.maojianwei.leetcode.format.dp;

/**
 * 11
 * desc: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 */
public class MaxContainer {


    /**
     * 双指针： 向中间靠拢的过程中，不断更新即可，时间复杂度为O（n)
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int i = 0;
        int j = height.length-1;
        int vol = 0;
        while( i < j){
            int tmp = Math.min(height[i], height[j]) * (j - i);
            vol = tmp > vol ? tmp : vol;
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return vol;
    }


}
