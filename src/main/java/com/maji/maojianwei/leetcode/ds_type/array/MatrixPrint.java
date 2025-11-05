package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * desc: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 输入：matrix = [[1,2,3],
 *                [4,5,6],
 *                [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class MatrixPrint {

    /**
     * 模拟打印：关键是每层的边界在变化，可以使用额外的visited数组或者本解法的动态变化边界变量, 理解简单
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom  = matrix.length - 1;

        int[] result = new int[matrix[0].length * matrix.length];
        int count = 0;
        while(true){
            for(int i = left;i<=right;++i){     // 由左至右  坐标为 matrix[top][left -> right]， 结束后 top+1
                result[count++] =  matrix[top][i];
            }
            if(++top > bottom) break;
            for(int i = top;i<=bottom;++i){     // 由上至下  坐标为 matrix[top -> bottom][right]， 结束后 right-1
                result[count++] =  matrix[i][right];
            }
            if(--right < left) break;
            for(int i = right;i>=left;--i){     // 由右至左  坐标为 matrix[bottom][right -> left]， 结束后 bottom - 1
                result[count++] =  matrix[bottom][i];
            }
            if(--bottom < top) break;
            for(int i = bottom;i>=top;--i){     // 由下至上  坐标为 matrix[bottom -> top][left]， 结束后 left + 1
                result[count++] =  matrix[i][left];
            }
            if(++left > right) break;
        }
        return result;
    }


}
