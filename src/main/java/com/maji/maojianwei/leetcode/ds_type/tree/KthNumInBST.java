package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.ListNode;
import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.DelayQueue;

/**
 * desc: 给定一棵二叉搜索树，请找出其中第k大的节点
 */
public class KthNumInBST {

    /**
     * 方法1： 引入getTreeSize()方法， 思想简单， 但是具有较多的重复计算， 效率较低
     */
    public int kthLargest(TreeNode root, int k) {
        k = getTreeSize(root) - k + 1;
        int rank;
        while(true){
            rank = getTreeSize(root.left) + 1;
            if( rank == k){
                return root.val;
            }else if(rank > k ){
                root = root.left;
            }
            else{
                root = root.right;
                k -= rank;
            }
        }
    }

    public int getTreeSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }

    /**
     * 方法2： 引入全局变量，中序遍历（ right -> root ->left ), 时间复杂度为 O（k)
     *
     */

    public static int kthLargest3(TreeNode root , int k){

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        // 反向的中序遍历
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.right;
            } else {
                if(--k == 0){
                    return stack.peek().val;
                }
                cur = stack.pop().left;
            }
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (k == 0) {
            return 0;
        }
        Deque<TreeNode> stack =  new ArrayDeque<>();
        TreeNode curNode = root;
        int count = 0;
        while(curNode != null || !stack.isEmpty()) {
            if (curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                TreeNode peekNode = stack.pop();
                count++;
                if ( count == k ) {
                    return peekNode.val;
                }
                curNode = peekNode.right;
            }
        }
        return -1;

    }
}
