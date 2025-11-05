package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class: 动态规划
 * 最优解特征： 以某数为结尾的最长子段和要么是0 要么是以上一个数为结尾的序列的最长子段和 加上该元素的值
 * 构建b[j] 表示 以 a[j] 为结尾的序列的最长子段和
 * if j == 1 b[j] = max{0, a[1] };
 * if j != 1 b[j] = max{0, b[j-1] + a [j] };
 * * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 12:40
 */
public class DP_3_MaxSubSum3 {
    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("maxSubSum: "+ maxSubSum(array));
        System.out.println("maxSubSum: "+ maxSubSum2(array));
    }


    /* 注意 sum[n-1] 并不是最终的结果，最终的结果是 sum 中的最大值，时间复杂度为 O（n）  */
    public static int maxSubSum(int[] array){
        int[] record = new int[array.length];
        record[0] = Math.max(0, array[0]);
        int maxSum = record[0];
        for(int i =1 ; i< array.length; i++){
            record[i] = Math.max(record[i-1] + array[i], 0);
            maxSum = maxSum < record[i] ? record[i] :maxSum;
        }
        return maxSum;
    }

    public static int maxSubSum2(int[] array){
        int sum = 0;
        int maxSum = 0;
        for(int i = 0 ;i<array.length; i++){
            if(sum < 0){
                sum = array[i];
            } else{
                sum += array[i];
            }
            maxSum = maxSum < sum? sum: maxSum;
        }
        return maxSum;
    }

}
