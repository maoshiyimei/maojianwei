package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111
 * 树从更节点到叶子节点的最小长度，即最小深度
 */

public class MinDepth {

    /**
     *  递归方法
     */
    public static int minDepth1(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }

    /**
     * 非递归方法：遍历， 找到第一个叶子节点就停止
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i = 0 ; i< size; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    return depth;
                }
                if(cur.left != null ){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return depth;
    }
}
