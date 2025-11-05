package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 543
 * desc: 二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class TreeLength {

    public  int maxLength = 0;

    public  int getLongestLength(TreeNode root){
        maxLength = 0;
        dfs(root);
        return maxLength;

    }

    /**
     * 思路：
     *  最长路径要么过根节点， 要么不过，第二种需要在中间遍历每个节点时进行判断和更更新
     * 返回结果是以root为起点的最长路径，
     * @param root
     * @return
     */
    public  int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMaxLength = dfs(root.left);
        int rightMaxLength = dfs(root.right);
        if(leftMaxLength + rightMaxLength + 1 > maxLength){
            maxLength = leftMaxLength + rightMaxLength + 1;
        }
        return leftMaxLength > rightMaxLength ? leftMaxLength + 1 : rightMaxLength +1 ;
    }

    /**
     * 如果是计算直径（两个节点视为长度 = 1 ，则需要注意这个DFS中不要+1
     * @param root
     * @return
     */


    public int diameterOfBinaryTree(TreeNode root) {
        maxLength = 0;
        dfs(root);
        return maxLength;
    }

    public int dfs2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLength = dfs2(root.left);
        int rightLength = dfs2(root.right);
        //区别！
        maxLength = Math.max(leftLength + rightLength, maxLength);
        return Math.max(leftLength, rightLength) + 1;
    }



}
