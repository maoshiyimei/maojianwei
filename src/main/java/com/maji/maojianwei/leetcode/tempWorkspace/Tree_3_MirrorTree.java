package com.maji.maojianwei.leetcode.tempWorkspace;



import com.maji.maojianwei.leetcode.entity.Tree;
import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * example: [4,2,7,1,3,6,9] - > [4,7,2,9,6,3,1]
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/15 , 20:56
 */
public class Tree_3_MirrorTree {
    public static TreeNode root = Tree.generate(new int[]{4,2,7,1,3,6,9});
    public static void main(String[] args) {

        Tree.print(root);
        mirrorTree2(root);
        Tree.print( root);
    }
    /* 非递归 复制算法*/
    public static TreeNode mirrorTree(TreeNode root){

        Queue<TreeNode> parentQueue = new LinkedList<>();
        if(null != root){
            parentQueue.offer(root);
        }
        while( !parentQueue.isEmpty() ){
            TreeNode curNode = parentQueue.poll();
            TreeNode tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;
            if( null != curNode.left){
                parentQueue.offer(curNode.left);
            }
            if( null != curNode.right ){
                parentQueue.offer(curNode.right);
            }
        }
        return root;
    }

    /* 递归算法 */
    public static void mirrorTree2(TreeNode root){
        if( root  == null ){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree2(root.left);
        mirrorTree2(root.right);
    }

}
