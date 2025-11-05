package com.maji.maojianwei.leetcode.entity;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Class: 根据 数组（int)生成二叉树，数值在为正值，如果数值为-1 表示为空指针的节点
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/15 , 19:49
 */
public class Tree{

    public static TreeNode generate(int[] nodes){
        int n = nodes.length;
        if( n == 0 || nodes[0] == -1 || !judgeNodeNum(n)  ){
            return null;
        }
        TreeNode head = new TreeNode(nodes[0]);
        Queue<TreeNode> parentQueue = new LinkedList<>();
        parentQueue.offer(head);
        int index = 1;
        while (!parentQueue.isEmpty() && index < n ) {
            TreeNode curNode = parentQueue.poll();
            int leftValue = nodes[index++];
            int rightValue = nodes[index++];
            if(leftValue!= -1){
                TreeNode leftNode = new TreeNode(leftValue);
                curNode.left = leftNode;
                parentQueue.offer(leftNode);
            }
            if(rightValue!= -1){
                TreeNode rightNode = new TreeNode(rightValue);
                curNode.right = rightNode;
                parentQueue.offer(rightNode);
            }
        }
        return head;
    }
    /*  创建二叉搜索树，不重复，双亲严格大于左孩子，严格小于右孩子 */
    public static TreeNode generateBinaryTree(int[] nodes){
        int n = nodes.length;
        if( n == 0 ){
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        for(int i =1 ; i < n ; i ++ ){
            TreeNode curNode = root;
            while( null != curNode){
                if(curNode.val > nodes[i]){
                    if(null != curNode.left){
                        curNode = curNode.left;
                        continue;
                    }
                    else{
                        curNode.left = new TreeNode(nodes[i]);
                        break;
                    }

                }
                if(curNode.val< nodes[i] ){
                    if(null != curNode.right) {
                        curNode = curNode.right;
                        continue;
                    }
                    else {
                        curNode.right = new TreeNode(nodes[i]);
                        break;
                    }

                }
                if(curNode.val == nodes[i] ){
                    break;
                }

            }
        }
        return root;
    }
    public static void print(TreeNode head){

        Queue<TreeNode> parentQueue = new LinkedList<>();
        if(head!= null){
            parentQueue.offer(head);
        }
        while( ! parentQueue.isEmpty()){
            int parentNum = parentQueue.size();
            for(int i = 0 ;i < parentNum ; i ++){
                TreeNode curNode = parentQueue.poll();
                System.out.print(curNode.val + "    ");
                if(curNode.left !=null ){
                    parentQueue.offer(curNode.left);
                }
                if(curNode.right != null){
                    parentQueue.offer(curNode.right);
                }
            }
            System.out.println();
        }
    }
    public static boolean judgeNodeNum(int n ){
        if(n<0){
            return false;
        }
        n+=1;
        while( n != 1){
            if(n%2 != 0 ){
                return false;
            }
            n/=n ;
        }
        return true ;
    }
    public static int deep(TreeNode root){
        if( null == root){
            return 0;
        }
        else{
            return 1+ Math.max( deep(root.left), deep(root.right) );
        }
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
