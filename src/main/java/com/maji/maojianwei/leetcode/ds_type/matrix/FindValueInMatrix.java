package com.maji.maojianwei.leetcode.ds_type.matrix;

/**
 * 74. 搜索二维矩阵
 * 中等
 * 876
 * 相关企业
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 */

public class FindValueInMatrix {


    /**
     * 实际上按行整体上是有序的， 因此可以使用二分查找的方式
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols -1;
        // 注意加上等号
        while (left <= right) {
            int mid = left + (right-left)/2;
            // 这个坐标都是和cols决定的， 和rows没有关系
            if (matrix[mid/cols][mid%cols] == target) {
                return true;
            }
            if (matrix[mid/cols][mid%cols] > target){
                right = mid-1;
            } else {
                left = mid+1;
            }

        }
        return false;
    }


}
