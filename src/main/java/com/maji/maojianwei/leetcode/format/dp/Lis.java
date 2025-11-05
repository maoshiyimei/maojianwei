package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * 300
 * desc: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class Lis {
    /**
     * 方法1： 利用最长公共子序列方法, 这个方法不是完全正确的，因为要求严格递增，所以如果{1,1,1,1,1} 的结果会是5而不是1，
     */
    public static int[] getLis(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        return lcs(array, sortedArray);
    }

    public static int[] lcs(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        int[][] record = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    record[i][j] = 3;
                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                    record[i][j] = 2;
                }
                else{
                    dp[i][j] = dp[i][j-1];
                    record[i][j] = 1;
                }
            }
        }

        int[] res = new int[dp[n][m]];
        int k  = res.length-1;
        int p = n;
        int q = m;
        while(p > 0 && q >0){
            if(record[p][q] == 3){
                res[k--] = arr1[p-1];
                p--;
                q--;
            } else if( record[p][q] == 2){
                p--;
            } else{
                q--;
            }
        }
        return res;
    }

    /**
     * 方法2： 动态规划， 定义一个数组， count[i] 表示以 array[i] 结尾的 lis的长度
     * 时间复杂度 n * n 和使用lcs同
     *
     */
    public static int[] getLis2( int[] data ){
        int[] count = new int[data.length];
        Arrays.fill(count, 1);
        int maxLength = 1;
        for(int i = 1; i<data.length; i++){
            for(int j= i-1; j >=0; j--){
                if(data[j] <= data[i]){
                    //对于遇到的每一个小于它的值，盘算一下是否加入
                    count[i] = Math.max(count[i], count[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, count[i]);
        }

        //找到序列(多个序列中随机的一个)
        int[] res = new int[maxLength];
        int lastNum = Integer.MAX_VALUE;
        for(int i = data.length-1, k = maxLength-1; i>=0; i--){
            if(count[i] == maxLength && data[i] <= lastNum){
                lastNum = data[i];
                res[k--] = data[i];
                maxLength--;
            }
        }
        return res;
    }

    /**
     * 方法3： 动态规划，存储的含义不同，dp[]中存储的是一个递增串（不是最终的lis), 但是长度是一样的 时间为nlogn
     * 对于每一个新的元素，要么比dp中所有的都大添加到末尾， 要么要与某个大于它的值替换（最小的大于），替换是为了以后可能成为新的一部分
     *
     * 问题是没有办法获得这个序列
     */
    public static int getLis3(int[] data) {
        int[] dp = new int[data.length] ;

        int  num =0;
        for (int i = 0; i < data.length; i++) {
            // 查找范围是已有的0 ~ num-1,
            int left = 0, right = num-1;
            // 二分查找找到第一个小于的位置，
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (dp[mid] >= data[i]) {
                    right = mid -1;
                } else {
                    left  = mid +1;
                }
            }
            //此时一定是 left > right
            dp[left] = data[i];
            //加到末尾，数据增加了
            if (left == num) {
                num++;
            }
        }
        return num;
    }

    /**
     * 练习
     */
    public int lis4(int[] nums) {
        int n = nums.length;
        int[] record = new int[n];
        int count = 0;
        for(int i = 0 ;i< n;i++){
            int left = 0;
            int right = count-1;
            while(left <= count){
                int mid = left + (right-left)/2;
                if(record[mid] >= nums[i]){
                    right = mid-1;
                }
                else{
                    left = mid +1;
                }
            }
            right++;
            record[right] = nums[i];
            if(right == count){
                count++;
            }
        }
        return count;
    }


}
