package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * desc : 判断是否是对称二叉树， 一个镜像和自己一样的树
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) //特殊情况
            return true;
        return compare(root.left, root.right);
    }

    /**
     *  递归算法；
     *  注意逻辑是：对于对应位置的两个节点，需要满足：
     *      （1）值相同
     *      （2）形状相同，即对称位置的节点比较应该相同
     */
    public boolean compare(TreeNode lNode, TreeNode rNode){
        if(lNode == null && rNode == null){
            return true;
        }
        if(lNode == null || rNode == null || lNode.val != rNode.val ){
            return false;
        }
        return compare(lNode.left, rNode.right) && compare(lNode.right, rNode.left);
    }

}
