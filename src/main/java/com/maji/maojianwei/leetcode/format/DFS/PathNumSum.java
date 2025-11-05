package com.maji.maojianwei.leetcode.format.DFS;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 计算从根到叶子节点生成的所有数字之和
 *
 * @Author maojianwei
 * @Date 2020/8/6 18:49
 **/
public class PathNumSum {
    public static int s =0 ;
    public static int sp=0;
    public static void main(String[] args){

    }
    /* 使用栈而非递归方法 wrong */
    public static  int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Deque<TreeNode> parents = new ArrayDeque<>();
        parents.push(root);
        int pathSum = root.val;
        while(!parents.isEmpty()){
            TreeNode curNode = parents.peek();
            while(curNode.left!=null){
                curNode = curNode.left;
                pathSum*=10;
                pathSum+=curNode.val;
                parents.push(curNode);
            }
            if(curNode.right!=null){
                curNode = curNode.right;
                pathSum*=10;
                pathSum+=curNode.val;
                parents.push(curNode);
                continue;
            }
            else{
                sum+=pathSum;
                pathSum/=10;
                TreeNode forNode = null;
                while(true){
                    forNode = parents.pop();
                    if(parents.isEmpty())
                        return sum;
                    curNode = parents.peek();
                    if(curNode.right != forNode)
                        break;
                    forNode =curNode;
                    pathSum/=10;
                }
            }
        }
        return sum;
    }
    /* 递归算法 */
    public static  int sumNumbers2(TreeNode root) {
        return dfs(root, 0);

    }
    public static int dfs(TreeNode root, int i){
        if (root == null)
            return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return dfs(root.left, temp) + dfs(root.right, temp);
    }




}
