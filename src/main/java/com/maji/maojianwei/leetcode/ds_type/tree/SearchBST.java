package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 700
 * desc: 二叉搜索树的搜索
 */
public class SearchBST {

    /**
     * 非递归
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(cur != null){
            if(root.val == val ){
                return cur;
            }
            if(root.val > val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;

    }

    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        } else if (root.val < val){
            return searchBST2(root.right, val);
        } else{
            return searchBST2(root.left, val);
        }
    }
}
