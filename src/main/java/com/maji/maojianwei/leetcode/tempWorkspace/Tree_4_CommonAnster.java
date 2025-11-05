package com.maji.maojianwei.leetcode.tempWorkspace;

import com.maji.maojianwei.leetcode.entity.Tree;
import com.maji.maojianwei.leetcode.entity.TreeNode;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Class: Ѱ�����������ڵ�Ĺ�ͬ����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/9 , 12:32
 */
public class Tree_4_CommonAnster {
    public static void main(String[] args){
        int[] treeValue = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root  = Tree.generate(treeValue);
        Tree.print(root);
        System.out.println(4 + ", " + 10 + " : " + getCommonAnster( root, 4, 10 ) );
        System.out.println(8 + ", " + 9 + " : " + getCommonAnster( root, 8, 9 ) );
        System.out.println(10 + ", " + 11 + " : " + getCommonAnster( root, 10, 11 ) );
        System.out.println(8 + ", " + 2 + " : " + getCommonAnster( root, 8, 2 ) );
    }
    /* ˼·��  */
    public static int getCommonAnster(TreeNode root , int value1, int value2){
        List<TreeNode> path1 = new LinkedList<>();
        List<TreeNode> path2 = new LinkedList<>();
        if(!findPathFromRoot(root, value1, path1) || !findPathFromRoot(root, value2, path2) ){
            return -1;
        }
        int i = 0 ;
        for(; i< path1.size() && i < path2.size(); i++){
            if(path1.get(i).val != path2.get(i).val){
                return path1.get(i-1).val;
            }
        }
        /* ���������ж��Ǵ�������Ϊĳһ��㱾����������*/
        if( i == path1.size() ){
            return path1.get(i-1).val;
        }
        if( i == path2.size()){
            return path2.get(i-1).val;
        }
        return -1;
    }
    /* �ݹ����·���Ƚϼ򵥣�����ҵ������棬�������ҵ����أ�������û����ȥ�ұߣ��������ұ߶�û�У��ýڵ㵯�����ɡ�*/
    public static  boolean findPathFromRoot( TreeNode root , int value, List<TreeNode> path){
        if( root == null ){
            return false;
        }
        path.add(root);
        if(root.val == value ){
            return true;
        }
        boolean flag = false;
        if(root.left != null ){
            flag = findPathFromRoot(root.left, value, path);
        }
        if( !flag  && root.right != null ){
            flag = findPathFromRoot(root.right, value, path);
        }
        if( !flag ){
            path.remove(path.size()-1);
        }
        return flag;
    }
}
