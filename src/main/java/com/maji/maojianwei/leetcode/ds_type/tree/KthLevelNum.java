package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 *  desc: 二叉树第k层的节点数目
 */
public class KthLevelNum {

    /**
     * 递归算法
     */
    public static int getKthLevelNum(TreeNode root , int k){
        if(root == null || k <= 0){
            return 0;
        }
        if(root != null && k == 1){
            return 1;
        }
        return getKthLevelNum(root.left, k-1) + getKthLevelNum(root.right, k-1);

    }
}
