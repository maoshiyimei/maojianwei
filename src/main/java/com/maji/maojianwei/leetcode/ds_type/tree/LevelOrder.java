package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102
 * desc: 层序遍历
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode curNode;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i< size; i++){
                curNode = queue.poll();
                level.add(curNode.val);
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    queue.offer((curNode.right));
                }
            }
            res.add(level);
        }
        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for(int i = 0 ; i < levelSize; i++){
                TreeNode curNode = queue.poll();
                levelList.add(curNode.val);
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(levelList);
        }

        return res;

    }
}
