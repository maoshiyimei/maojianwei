package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class: 分治法求解该问题：
 * 特征： 最长子段要么在左边，要么在右边，要么横跨中点，三者的最大值就是最终解
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 12:34
 */
public class DP_3_MaxSubSum2 {

    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("maxSubSum: "+ maxSubSum(array, 0 , n-1));
    }
    /*分治法的时间复杂度为 O（nlog n)*/
    public static int maxSubSum(int[] array,int left,int right) {
        if(left == right)
            return array[left];
        else {
            int mid =( left+right)/2;
            int leftMax = maxSubSum(array,left,mid); //case 1
            int rightMax = maxSubSum(array,mid+1,right); //case 2
            int midMax = maxMidSubSum(array,left,mid,right); //case 3
            //输出最大的，要么在左边，要么在右边，要么就是横跨中点的
            int max = leftMax > rightMax ? leftMax : rightMax;
            max = max > midMax ? max : midMax ;
            return max;
        }
    }
    /*  需要注意： 返回的至少包含 mid 和 mid+1 两个值的和！！！！！ */

    public static int maxMidSubSum(int[] array, int left, int mid, int right) {
        int leftSum =0;
        int temp1 = Integer.MIN_VALUE;
        for(int i = mid ;i>=left;i--) {
            leftSum += array[i];
            if(leftSum > temp1 ) {
                temp1 = leftSum;

            }
        }
        int rightSum =0;
        int temp2 = Integer.MIN_VALUE;
        for(int j = mid+1 ; j<= right; j++) {//右边计算最大和，也是连续的，加到最大为止
            rightSum += array[j];
            if(rightSum > temp2) {
                temp2 = rightSum;
            }
        }
        return temp1 + temp2;
    }
}
