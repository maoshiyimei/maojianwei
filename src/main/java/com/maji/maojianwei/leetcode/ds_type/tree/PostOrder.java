package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.*;

/**
 * 145
 * desc : 后序遍历
 */
public class PostOrder {


    /**
     * 递归算法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    /**
     * 非递归算法1: 基于前序遍历， 注意两点：
     *  （1）先将左孩子入栈，后访问，这与标准前序列是相反的；
     *  （2）结果序列需要reverse，才是 （ left -> right -> root)
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curNode;
        while(!stack.isEmpty()){
            curNode  = stack.pop();
            res.add(curNode.val);
            if(curNode.left != null){
                stack.push(curNode.left);
            }
            if(curNode.right != null){
                stack.push(curNode.right);
            }

        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 递归算法2: 基于前序遍历， 注意两点：
     *  （1）先查看右孩子，然后看左孩子， 与前序相反
     *  （2）结果序列需要reverse，才是 （ left -> right -> root)
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.right;
            }
            else{
                curNode = stack.pop().left;
            }
        }
        Collections.reverse(res);
        return res;
    }
    /**
     * 递归算法3
     */
    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        // 记录最近访问的节点
        TreeNode visited = null;
        while(curNode!= null || !stack.isEmpty()){
            if(curNode != null){
                // 统一标准：只有在这里会进行入栈操作
                stack.push(curNode);
                curNode = curNode.left;
            } else{
                // 没有左孩子，再看右孩子，暂时不能把节点弹出来，
                TreeNode parentNode = stack.peek();
                if(parentNode.right != null && parentNode.right != visited){
                    curNode = parentNode.right;
                } else {
                    res.add(parentNode.val);
                    // 如果没有这个访问标识，则会不断去查看右孩子陷入循环
                    visited = parentNode;
                    stack.pop();
                }
            }
        }


        return res;
    }
}
