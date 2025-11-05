package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 543
 * desc: 二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class TreeLengthIncludeRoot {

    /**
     * 找到左右子树的最大树高度即
     * @param root
     * @return
     */
   public static int findMaxLengthThroughRoot(TreeNode root){
       if(root == null){
           return 0;
       }
       return depth(root.left) + depth(root.right) + 1;
   }

   public static int depth(TreeNode root){
       if(root == null){
           return 0;
       }
       return Math.max(depth(root.left), depth(root.right)) +1 ;
   }

}
