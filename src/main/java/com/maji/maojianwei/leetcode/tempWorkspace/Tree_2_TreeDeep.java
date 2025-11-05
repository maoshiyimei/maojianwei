package com.maji.maojianwei.leetcode.tempWorkspace;

import com.maji.maojianwei.leetcode.entity.Tree;
import com.maji.maojianwei.leetcode.entity.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Class: 求解二叉树的深度
 * example： 给定二叉树 [3,9,20,null,null,15,7]，输出深度为3
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/15 , 19:45
 */
public class Tree_2_TreeDeep {
    public static TreeNode root = Tree.generate(new int[]{3,9,20,-1,-1,15,7});

    public static void main(String[] args){
            System.out.println( getDeep(root) );
    }
    /* 使用队列来计算深度 */
    public static int getDeep(TreeNode head) {
        Queue<TreeNode> parentQueue = new LinkedList<>();
        if(null != root ){
            parentQueue.offer(head);
        }
        int deep = 0;
        while(! parentQueue.isEmpty() ){
            int parentNum = parentQueue.size();
            while(parentNum-- != 0){
                TreeNode curNode = parentQueue.poll();
                if(null != curNode.left) {
                    parentQueue.offer(curNode.left);
                }
                if( null != curNode.right ){
                    parentQueue.offer(curNode.right);
                }
            }
            deep++;
        }
        return deep;
    }
    /* 使用递归算法来计算深度*/
    public static int getDeepByRecursion(TreeNode root){
        if( null == root){
            return 0;
        }
        else{
            return 1+ Math.max( getDeepByRecursion(root.left), getDeepByRecursion(root.right) );
        }
    }

}
