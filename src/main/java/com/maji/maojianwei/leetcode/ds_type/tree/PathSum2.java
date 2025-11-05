package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113
 * desc: 找到从根节点到叶子节点路径总和等于给定目标和的所有路径
 */
public class PathSum2 {

    /**
     * 路径需要两个参数保存
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        List<Integer> curPath = new ArrayList<>();
        findAllPath(root, targetSum, curPath, paths);
        return paths;
    }

    /**
     * 注意当前路径需要不断回溯
     *
     * @param root
     * @param sum
     * @param curPath
     * @param paths
     */
    public void findAllPath(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> paths){
       if(root == null){
           return;
       }
       sum -= root.val;
       // 加入path
       curPath.add(root.val);
       if(root.left == null && root.right == null){
           if(sum == 0){
               paths.add(new ArrayList<>(curPath));
           }
           curPath.remove(curPath.size()-1);
           return;
       }
       findAllPath(root.left, sum, curPath,paths);
       findAllPath(root.right, sum, curPath, paths);
       // 从path去掉
       curPath.remove(curPath.size()-1);

    }



}
