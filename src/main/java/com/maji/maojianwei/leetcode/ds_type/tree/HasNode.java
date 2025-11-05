package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * desc: 二叉树中是否包含给定的节点
 */
public class HasNode {

    public static boolean contain(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        if(root == target){
            return true;
        }
        // 剪枝
        boolean leftRes = contain(root.left, target);
        return leftRes || contain(root.right, target);
    }

}
