package com.maji.maojianwei.leetcode.ds_type.tree;


import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树高计算
 * 等价与问题： 计算根节点到叶子节点的最大长度
 */
public class TreeDepth {

    /**
     * 树高的递归计算
     * @param root
     * @return
     */
    public static int deep(TreeNode root){
        if(root == null){
            return 0 ;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    /**
     * 使用非递归算法： 借助队列层次遍历， 每一层加1
     * @param root
     * @return
     */
    public static int deep2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth ++;
           for(int i = 0; i< size; i++){
               TreeNode curNode = queue.poll();
               if(curNode.left != null){
                   queue.offer(curNode.left);
               }
               if(curNode.right != null){
                   queue.offer(curNode.right);
               }
           }
        }
        return depth;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
