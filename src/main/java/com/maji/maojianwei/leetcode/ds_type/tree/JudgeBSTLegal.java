package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

public class JudgeBSTLegal {

    /**
     * 98. 验证二叉搜索树
     * 中等
     * 2.2K
     * 相关企业
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

       return dfs(root,Long.MIN_VALUE, Long.MAX_VALUE);

    }

    /**
     * 自上下下
     * @param root
     * @return
     */
    public boolean dfs(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        // =支持非严谨BST
        if (root.val <= lower || root.val >= upper ){
            return false;
        }

        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }


}
