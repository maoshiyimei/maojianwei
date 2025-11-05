package com.maji.maojianwei.leetcode.format.slide_window;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class:给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1
 * 10 2
 * 1 0 0 1 0 1 0 1 0 1 - > 5
 */
public class MaxSeriesOne {


    /**
     * 思路： 借助队列，保存修改的下标，之后不断向右移动， 中间遍历新的最大长度
     */
    public int solutionOne(int[] array, int k ){
        Queue<Integer> locations = new LinkedList<>();
        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;
        for(int i = 0 ; i< array.length; i++){
            if(array[i] == 1){
                curLen++;
            }
            else{
                if(locations.size() < k){
                    locations.offer(i);
                    curLen++;
                }
                else{
                    int lastLocation = locations.poll();
                    locations.offer(i);
                    curLen = i - lastLocation;
                }
            }
            if(curLen > maxLen){
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
