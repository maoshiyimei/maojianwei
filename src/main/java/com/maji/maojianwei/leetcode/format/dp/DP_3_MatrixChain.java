package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class: 矩阵链的最小乘积数
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 10:22
 */
public class DP_3_MatrixChain {
    private static int N = 20;
    private static int[] p = {5,10,3,12,5,50,6,7,10,20,28,2,12,5,3,12,23,33,2,12,2,};

    public static void main(String[] args) {
        int result = matrixChainOrder(p,1, N);
        System.out.println(result);
    }
    /* 暴力递归，计算了大量的重复子问题 且是自顶向下的  */
    public static int matrixChainOrder(int[] p, int start, int end) {
        if( start == end ) {
            return 0;
        }
        int multiNum = Integer.MAX_VALUE;
        for(int k = start ; k <= end-1; k++) {//子问题求解
            int temp = matrixChainOrder(p, start , k ) + matrixChainOrder( p,k+1, end ) + p[start-1]*p[k]*p[end];
            if( temp < multiNum )
                multiNum = temp;
        }
        return multiNum ;
    }
}
