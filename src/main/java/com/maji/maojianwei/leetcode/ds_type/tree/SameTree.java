package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 100
 * desc: 相同的树，结构和指完全相同
 *
 */
public class SameTree {

    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
