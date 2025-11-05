package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */

public class MaxWalterVol {

    // S(i,j)=min(h[i],h[j])×(j−i)
    // 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1变短：
    //若向内 移动短板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
    //若向内 移动长板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
    public int maxArea(int[] height) {
        int left  = 0;
        int right = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int curArea = Math.min(height[right], height[left]) * (right-left);
            maxArea = Math.max(curArea, maxArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;

    }


}
