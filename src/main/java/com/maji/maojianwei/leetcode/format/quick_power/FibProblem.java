package com.maji.maojianwei.leetcode.format.quick_power;

/** 斐波那契数列 使用矩阵快速幂求解
 * @author weitong
 * @date 2022/01-19 8:19 下午
 */
public class FibProblem {

    /**
     * 矩阵乘法
     */
    private static long[][] matrixMul(long[][] matrixA, long[][] matrixB) {
        int row = matrixA.length;
        int col = matrixB[0].length;
        int mid = matrixB.length;
        long[][] ans = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < mid; k++) {
                    ans[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return ans;
    }

    /**
     * 斐波那契数列计算:ans = matrix^n-1 * ans
     */
    public static int fib(int n) {
        if (n <= 1) return n;
        long[][] matrix = new long[][]{
                {1, 1},
                {1, 0}
        };
        long[][] ans = new long[][]{
                {1},
                {0}
        };
        int x = n - 1;
        while (x != 0) {
            if ((x & 1) != 0) ans = matrixMul(matrix, ans);
            matrix = matrixMul(matrix, matrix);
            x >>= 1;
        }
        return (int)ans[0][0];
    }

}
