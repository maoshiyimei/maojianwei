package com.maji.maojianwei.leetcode.format.dp;

import com.maji.maojianwei.leetcode.entity.TreeNode;

/**
 * 337
 * desc: 房子只有一个路口，是一课二叉树，同样项连的两个房间不能同时被抢劫，求最大收获
 */
public class Robbery3 {


    /**
     * 利用递归：
     */

    /**
     * 返回数组res[0]表示打劫root， res[1] 不打劫root
     * res[0] = 左孩子的res[1] + 右孩子的res[1] + root.val
     * res[1] = 左孩子中较大的 + 右孩子中较大的
     */
    public static int rob(TreeNode root){
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public static int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] resLeft = dfs(root.left);
        int[] resRight = dfs(root.right);

        int[] res = new int[2];
        res[0] = resLeft[1] + resRight[1] + root.val;
        res[1] = Math.max(resLeft[0], resLeft[1]) + Math.max(resRight[0], resRight[1]);
        return res;
    }



}
