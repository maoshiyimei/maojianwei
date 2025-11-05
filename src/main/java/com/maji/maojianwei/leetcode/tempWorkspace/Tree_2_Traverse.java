package com.maji.maojianwei.leetcode.tempWorkspace;

import com.maji.maojianwei.leetcode.entity.Tree;
import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class: 树的遍历方法：
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/16 , 19:15
 */
public class Tree_2_Traverse {
    public static TreeNode root = Tree.generateBinaryTree(new int[]{9,3,5,1,7,10,34,12,24,5,0,4,9,10,17});
    public static void main (String[] args){
        System.out.println(midOrderTraverse( root));
    }
    public static List midOrderTraverse(TreeNode root) {
        List<Integer> values = new LinkedList<>();
        Stack<TreeNode> parentStack = new Stack<>();
        TreeNode curNode = root;
        while (!parentStack.isEmpty() || null != curNode) {
            if (null != curNode) {
                parentStack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = parentStack.pop();
                values.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return values;
    }

}
