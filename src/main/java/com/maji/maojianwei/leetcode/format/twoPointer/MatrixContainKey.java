package com.maji.maojianwei.leetcode.format.twoPointer;

/**给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素
 * 返回true或false
 * @Author maojianwei
 * @Date 2020/8/13 14:52
 **/
public class MatrixContainKey {
    /*双指针 从右上角开始找，两个指针i 和 j 分别指向行和列，
     利用矩形自身的特点这样每次都有两个确定的选择，如果从头开始则没有办法确定那个选择
     ，只能不断重复，当然也可以总左下角开始

     这个双指针其实不是严格意义的，只是坐标， 查找效率很高，时间复杂度为 行列数
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int i=0, j=m-1;   //右上角开始轮询
        while(i < n && j >= 0){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int i=n-1, j=0;   //左下角开始轮询
        while(i >=0 && j <m){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                j++;
            else
                i--;
        }
        return false;
    }




}
