package com.maji.maojianwei.leetcode.ds_type.tree;

import com.maji.maojianwei.leetcode.entity.TreeNode;

import java.util.PriorityQueue;

/**
 * 霍夫曼树编码
 */
public class HuffmanTreeDemo {
    static class Node{
        private char element;
        private int weight;
        private Node left;
        private Node right;
        private String code = "";

        public Node(){

        }

        public Node(char element, int weight){
            this.element = element;
            this.weight = weight;
        }

    }

    /**
     * 心成城只有一个节点的树
     */
    static class Tree implements Comparable<Tree>{
        Node root;
        public Tree(char element, int weight){
            root = new Node(element, weight);
        }

        /**
         * 合并两颗树为一颗
         */
        public Tree(Tree tree1, Tree tree2){
            root = new Node();
            root.element = '*';
            root.weight = tree1.root.weight + tree2.root.weight;
            root.left = tree1.root;
            root.right = tree2.root;
        }

        /**
         * 因为要求越频繁的越在底部，所以直接小根堆即可
         * @param o
         * @return
         */
        @Override
        public int compareTo(Tree o) {
            return this.root.weight - o.root.weight;
        }
    }

    /**
     * 传入的是字符访问频率数组：int size = 26
     * @param counts
     * @return
     */
    public static  Tree getHuffmanTree(int[] counts){

        PriorityQueue<Tree> priorityQueue = new PriorityQueue<>();
        for(int i = 0 ; i< counts.length ; i++){
            if(counts[i] != 0){
                priorityQueue.offer( new Tree((char)('a' + i), counts[i]));
            }
        }
        while(priorityQueue.size() > 1){
            Tree tree1 = priorityQueue.remove();
            Tree tree2 = priorityQueue.remove();
            priorityQueue.offer(new Tree(tree1, tree2));
        }
        return priorityQueue.remove();
    }

    public static String[] getHuffmanCode(Tree tree){
        if(null == tree){
            return null;
        }
        String[] res = new String[26];
        dfs(tree.root, res);
        return res;
    }

    public static void dfs(Node node, String[] res){
        //叶子节点
        if(node.left == null && node.right == null){
            res[node.element - 'a'] = node.code;
        } else{
            node.left.code = node.code + "0";
            dfs(node.left, res);
            node.right.code = node.code + "1";
            dfs(node.right, res);
        }
    }

    public static void main(String[] args){
        int[] counts = {
                3,4,6,2,78,7,4,18,3,2,
                6,7,13,3,89,34,1,1,23,3,
                5,1,2,8,90,4
        };
        Tree tree = getHuffmanTree(counts);
        String[] codes = getHuffmanCode(tree);
        for(String s : codes){
            System.out.println(s);
        }

    }

}
