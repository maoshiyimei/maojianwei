package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * desc: 二叉树第k层的叶子节点数
 */
public class KthLevelLeaf {

    /**
     * 递归算法:  k == 1 说明到了这一层，需要判断是否是叶子节点
     */
    public static int kthLevelLeaf(TreeNode root, int k){
       if(root == null || k <= 0){
           return 0;
       }
       if( root != null && k == 1 && root.left == null && root.right == null){
           return 1;
       }
       if( root != null && k == 1){
           return 0;
       }
       return kthLevelLeaf(root.left, k -1) + kthLevelLeaf(root.right, k-1);

    }


}
