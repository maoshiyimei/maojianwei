package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 15:33
 */
public class DP_3_MinSubSum {
    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("minSubSum: "+ minSubSum(array));
        System.out.println("minSubSum: "+ minSubSum2(array));
    }
    /* 注意 sum[n-1] 并不是最终的结果，最终的结果是 sum 中的最大值，时间复杂度为 O（n）  */
    public static int minSubSum(int[] array){
        int[] sum = new int[n];
        sum[0] = Math.min(array[0], 0 );
        int minSum = sum[0];
        for( int i = 1 ; i < n ;i ++){
            sum[i] = Math.min( 0, sum[i-1] + array[i] );
            if( minSum > sum[i]){
                minSum = sum[i];
            }
        }

        return minSum;
    }


    /**
     * 类似的。 一遇到前面的总和已经大于零就重新开始累加
     * @param array
     * @return
     */

    public static int minSubSum2(int[] array){
        int sum = 0;
        int minSum = sum;
        for(int i = 0 ;i < array.length ;i++){
            if(sum > 0){
                sum = array[i];
            } else{
                sum += array[i];
            }
            minSum = minSum > sum ? sum : minSum;
        }
        return minSum;
    }
}
