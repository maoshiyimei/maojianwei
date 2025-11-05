package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.ListNode;
import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 236
 * desc: 找到该树中两个指定节点的最近公共祖先, 注意一个节点可以是自己的祖先
 */
public class CommonAncestor {

    /**
     * 递归算法：
     * 非递归算法可以先找到两个节点的从跟的路径，然后找第一个共同路径节点即可，效率较差
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口： 找到某个节点或者子树遍历结束
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p , q);

        if(leftRes != null && rightRes != null){
            return root;
        }
        if(leftRes == null){
            return rightRes;
        }else{
            return leftRes;
        }
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftRes = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor2(root.right, p, q);
        if (leftRes != null && rightRes != null) {
            return root;
        }
        if (leftRes == null){
            return rightRes;
        } else {
            return leftRes;
        }

    }

    




}
