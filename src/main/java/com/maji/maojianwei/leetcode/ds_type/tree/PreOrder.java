package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144
 * desc: 前序遍历
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    /**
     *  递归算法
     */
    public void dfs(TreeNode root, List<Integer> data){
        if(root == null)
            return;
        data.add(root.val);
        dfs(root.left, data);
        dfs(root.right, data);
    }

    /**
     * 非递归算法：借助栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        // 注意应该是先将有孩子放入栈中, 入栈的都是没有访问过的
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }
    /**
     * 非递归算法2：
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        // 这种方法的逻辑是先一直遍历到最左边，同时将根节点加入结果，并入栈，然后弹出查看有节点，重复此过程。
        // 入栈的都是已经访问过的节点，后面依次推出来看是否右孩子， 需要维持一个遍历指针
        while(curNode != null || !stack.isEmpty()){
           if(curNode != null){
               stack.push(curNode);
               res.add(curNode.val);
               curNode = curNode.left;
           } else{
               //没有左孩子, 如果右孩子在的话再去看
               curNode = stack.pop().right;
           }
        }
        return res;
    }

}
