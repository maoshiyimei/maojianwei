package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.*;

public class RightSize_View {

    /**
     * 199. 二叉树的右视图
     * 中等
     * 997
     * 相关企业
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i= 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                // 最右侧的节点
                if (i == 0) {
                    res.add(curNode.val);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
            }
        }
        return res;

    }
}
