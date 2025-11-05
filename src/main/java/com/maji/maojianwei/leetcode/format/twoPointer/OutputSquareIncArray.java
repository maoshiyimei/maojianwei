package com.maji.maojianwei.leetcode.format.twoPointer;

/**一个递增序列，有正有负，请输出每个元素的平方的递增序列
 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序
 * @Author maojianwei
 * @Date 2020/8/10 16:57
 **/
public class OutputSquareIncArray {

    /* 双指针，双向， 时间为n ,因为已经是有序的两个子列表了 */
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int index = A.length-1;
        int left = 0;
        int right = A.length-1;
        for(int i = 0; i< A.length; i++ ){
            A[i] = A[i]*A[i];
        }

        while(left <= right){
            if(A[left] >= A[right]){
                result[index--] = A[left];
                left++;
            }
            else{
                result[index--] = A[right];
                right--;
            }
        }
        return result;
    }


}
