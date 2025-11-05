package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.ListNode;
import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * desc： 给定一个节点，找到从根节点到其路径
 */
public class NodePath {


    public static List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        if(root ==null || target == null)
            return path;
        findPath(root, target, path);
        return path;
    }

    /**
     * 前序遍历： 如果找到该节点直接返回，没有找到则从孩子上找， 如果孩子上也没找到，则这个子树上就没有找到
     */
    public static boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        path.add(root);
        if(root == target){
            return true;
        }
        boolean res = false;
        if(root.left!= null){
            res = findPath(root.left, target, path);
        }
        if(!res && root.right != null){
            res = findPath(root.right, target, path);
        }
        // 这个子树不在路径上需要删掉
        if(!res){
            path.remove(path.size()-1);
        }
        return res;
    }


}
