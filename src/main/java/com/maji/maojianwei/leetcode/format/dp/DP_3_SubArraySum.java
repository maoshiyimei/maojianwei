package com.maji.maojianwei.leetcode.format.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组	给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/9 , 12:41
 */
public class DP_3_SubArraySum {

    public static void main(String[] args){
        int[] array = {1,2,3,0,3,4,2,6,0,-3,2,1};//{1,2,3,}、{1，2，3，0}、{3,0,3}、{4,2}、{6}、{6，0}、{6,0,-3,2,1};
        System.out.println(solution1(array, 6));
        System.out.println(solution2(array, 6));
    }

    /* 每一个位置开头的数统计累积即可， 暴力求解 N2， 两层循环  */
    public static int solution1(int[] array, int k){
        int n = array.length;
        int count = 0;
        for(int i = 0 ; i< n ; i++ ){
            int sum = 0;
            for( int j = i ;j < n ; j++){
                sum += array[j];
                if( sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /*动态规划: 最优解 ：记录 sum 为累加和（前缀和）  ， 则如果之前的sum - k有多少个，那么这次就会有多少个新的，
            假设（k =70),
                在位置i 的时候  Prefix (i) = 100, 并且之前出现过前缀和为 30的情况，因为是由左往右遍历的，可以知道一定存在：
                在位置j(j < i) Prefix (j) = 30, 则j-i之间一定是连续的且和为70，
                *当然不一定只有一个j, 也有可能是j ,l , m (均<i),j-i、l-i、m-i之间都是连续的且和为70的
                *重点是每一个元素都需要将自己的前缀和存入哈希表中， 且需要在初始化的时候增加前缀和为0的特殊情况方便统一处理；

    *  */
    public static int solution2(int[] array, int k){
        int n = array.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for( int i = 0 ; i < n ;i++){
            sum += array[i];
            if( map.containsKey(sum - k )){
                count += map.get(sum - k );
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        for (int i = 0 ;i < nums.length; i++) {
            sum += nums[i];
            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum-k);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;

    }


}
