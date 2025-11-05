package com.maji.maojianwei.leetcode.format.greedy;

/**
 * 55 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class CanJump {

    /**
     * 对一个位置如果=3表示后面三个位置都能到达， 可以判断如果条最大是不是可以结束，这样可以减少判断次数提早结束循环
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //前n-1个元素能够跳到的最远距离
        int k = 0;
        // 注意i <= k 的含义：说明i的时候已经没法继续往下走了，是一个断点，后面不可能跨过去了，只有《=才有遍历左边剩余位置的意义
        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;

    }
}
