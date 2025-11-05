package com.maji.maojianwei.leetcode.format.twoPointer;

import java.util.LinkedList;
import java.util.Queue;

/**给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 返回仅包含 1 的最长（连续）子数组的长度。
 * @Author maojianwei
 * @Date 2020/8/11 18:39
 **/
public class LongestOneSubArray {
    public static void main(String[] args){
        int[] array = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes1(array, 2));
    }
    /* 双指针， 效率较低， 一个指针为工作指针，一个为指向最早替换的位置*/
    public static int longestOnes1(int[] A, int K) {
        int n = A.length;
        Queue<Integer> indexes = new LinkedList<>();
        int max = 0;
        int tempLength = 0;
        for(int i = 0 ;i<n;i++){
            if(A[i] == 1){
                tempLength++;
            }
            else if(indexes.size() < K ){
                tempLength++;
                indexes.offer(i);
            }
            else{
                max = Math.max(max, tempLength);
                if( K != 0){  // 如果K==0，需要特殊考虑
                    int earliestIndex = indexes.poll();
                    indexes.offer(i);
                    tempLength = i - earliestIndex;
                }
                else{
                    tempLength = 0;
                }
            }
        }
        max = Math.max(max, tempLength);
        return max;
    }
    /* 双指针， 优化，首先不需要特殊考虑K=0, 采用修改K--,不使用队列方法来存储索引，因为索引位置必然是left的下一个0,*/
    public int longestOnes2(int[] A, int K) {
        if(A == null || A.length == 0){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < A.length){
            if (A[right] == 0){
                if (K > 0){
                    K--;
                } else {
                    res = Math.max(res, right - left);
                    while (left < right && A[left] == 1){
                        left++;
                    }
                    left++;
                }
            }
            right++;
        }
        return Math.max(res, right - left);
    }
    /* 双指针，进一步优化，将内循环放在方面发循环一起处理， */
    public int longestOnes3(int[] A, int K) {
        int start = 0;
        int countZero = 0;
        for(int i = 0;i < A.length;i++){
            if(A[i] == 0)
                countZero++;
            if(countZero > K){
                if(A[start] == 0)
                    countZero--;
                start++;
            }
        }
        return A.length - start;
    }

}
