package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 112
 * desc: 从 根结点 到 叶子节点 是否存在和为targetSum的路径
 */

public class PathSum {

    /**
     * 递归算法
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPath (TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        // 叶子节点判断
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPath(root.left, targetSum) || hasPath(root.right, targetSum);
    }

}
