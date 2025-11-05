package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * desc : 判断一二叉树是否是完全二叉树
 */
public class JudgeCompleteTree {

    /**
     * 逻辑： 层次遍历， 完全二叉树的队列最后全部是null, 如果null出现在值之前不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return true;
        queue.offer(root);
        // 标识是已经出现了null, 后面就应该否是空的，
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if(curNode != null){
                if(flag == true){
                    return false;
                }
                queue.add(curNode.left);
                queue.add(curNode.right);
            }else{
                flag = true;
            }
        }
        return true;
    }

}
