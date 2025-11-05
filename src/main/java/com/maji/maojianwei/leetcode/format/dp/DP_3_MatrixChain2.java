package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class: 使用动态规划来求解问题
 * 最优解特征：i- m 之间的最小乘数，其中某两个子链决定的 即 i - k 和 k -m 都是其子链的最小，依次找到最小值，
 * 组织结构：二维数组，m[i][j]表示从 i 到 j 的最小步骤；
 * 递归方程： 当 i== j : m[i][j] = 0 ;
 *           当 i < j : m[i][j] = Min{ m[i][k] + m[k+1][j] + p[i-1]*p[k+1]*p[j] } 其中 i <= k <j
 * </>
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 10:32
 */
public class DP_3_MatrixChain2 {
    private static int N = 20;
    private static int[] p = {5,10,3,12,5,50,6,7,10,20,28,2,12,5,3,12,23,33,2,12,2,};

    public static void main(String[] args) {
        int result = matrixChainOrder();
        System.out.println(result);
    }
    /* 自底向上计算，用二维数据来存储已经计算过的子问题， 不用递归，时间复杂度 O（3^n） */
    public static int matrixChainOrder() {
        int n = p.length - 1 ;
        int[][] cost = new int[n+1][n+1]; // cost[i][j] 表示从第 i 个矩阵到第 j 个矩阵需要乘法的次数
        for( int i = 0 ;i <= n ; i ++ ){
            cost[i][i] = 0;
        }
        for(int i = 1 ; i <= n ; i ++){
            for( int j = i-1; j >= 1 ; j--){
                int multiMax = Integer.MAX_VALUE;
                for( int k = j; k< i ;k++){
                    int temp = cost[j][k] + cost[k+1][i] + p[j-1]*p[k]*p[i];
                    multiMax = temp < multiMax ? temp : multiMax;
                }
                cost[j][i] = multiMax;
            }
        }
        print(cost);
        return cost[1][n];
    }

    public static void print(int[][] array){
        for( int i= 0 ;i < array.length; i ++ ){
            for(int j = 0 ;j < array[0].length; j ++){
                System.out.print(array[i][j] + "            ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
