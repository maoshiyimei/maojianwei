package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 计算二叉树的节点个数
 */
public class CountNodes {
    public int countNodes(TreeNode root){
        if (root == null){
            return  0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
