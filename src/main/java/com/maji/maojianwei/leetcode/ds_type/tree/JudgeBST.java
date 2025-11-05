package com.maji.maojianwei.leetcode.ds_type.tree;

/**
 *
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同
 [4,8,6,12,16,14,10]  true
 */
public class JudgeBST {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 2 ) {
            return true;
        }
        return judgePostOrder(postorder, 0, postorder.length-2, postorder[postorder.length-1]);


    }

    public boolean judgePostOrder(int[] nums, int start, int end, int root){
        if (start >= end) {
            return true;
        }

        int index = start;
        for ( ; index <= end ; index++ ){
            if (nums[index] >= root) {
                break;
            }
        }
        for(int index2 = index; index2 <= end; index2++) {
            if (nums[index2] < root) {
                return false;
            }
        }

        boolean leftRes = true;
        if (index-1 >= 0 ){
            leftRes = judgePostOrder(nums, start, index-2, nums[index-1]);
        }
        if (!leftRes) {
            return false;
        }
        return judgePostOrder(nums, index, end-1, nums[end]);
    }

}
