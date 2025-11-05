package com.maji.maojianwei.leetcode.format.slide_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239
 * desc: 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 */
public class MaxInWindow {

    /**
     * 维护一个双向队列，队列中存储数组下标，对应数组元素递减， 这样每次选择队首的极为最大值，中间需要不断更新和淘汰窗口外面的位置。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        int[] result = new int[nums.length-k+1];
        for(int i = 0;i < nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }


    /**
     * 练习
     */

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if( k > nums.length || nums.length == 0){
            return new int[0];
        }
        // 第一个窗口特殊处理
        int[] res = new int[n-k+1];
        Deque<Integer> dequeue = new LinkedList<>();
        for( int i = 0; i < k; i++) {
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]  <= nums[i]) {
                dequeue.pollLast();
            }
            dequeue.offerLast(i);
        }
        res[0] = nums[dequeue.peekFirst()];

        // 维护更新后续窗口的值
        for( int i = k; i < n; i++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]  <= nums[i]) {
                dequeue.pollLast();
            }
            dequeue.offerLast(i);

            // 去调已经不再窗口范围内的数据
            while(dequeue.peekFirst() < i - k + 1) {
                dequeue.pollFirst();
            }
            res[i-k+1] = nums[dequeue.peekFirst()];
        }

        return res;
    }

}
