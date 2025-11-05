package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class:����һ�Ű���N���㡢N-1���ߵ�������ͨͼ���ڵ��1��N��ţ�ÿ���ߵĳ��Ⱦ�Ϊ1��
 * �������1�Žڵ����������������нڵ㣬��ô��·�������Ƕ��٣�
 * 4
 * 1 2
 * 1 3
 * 3 4 - > 4
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 23:06
 */
public class Graph_4_MinPath {
    public static Node[] head ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        initGraph( n );
        for(int i = 0 ;i < n-1 ; i++) {
            generateGraph( in.nextInt(), in.nextInt());
        }
        int deep  = calculateGraphDepth2();
        System.out.println(  2*(n-1) - deep );
    }
    /* ����ͼ�� i Ϊ���ڵ����� - ����ջ���������*/
    public static int calculateGraphDepth1(){
        int depth = 0 ;
        Stack<Integer> parentStack = new Stack<>();
        parentStack.push(1);
        int index = 1;
        int temp = 0;
        while(null != head[index].next || parentStack.size() !=1 ){
            if( null != head[index].next ){
                int tempIndex = head[index].next.value;
                head[index].next = head[index].next.next;
                index = tempIndex;
                temp++;
                depth = temp>depth?temp:depth;
                parentStack.push(index);
            }
            else{
                parentStack.pop();
                index = parentStack.peek();
                temp--;
            }
        }
        return depth;
    }

    /* ������ȣ� ���ڶ��У��������*/
    public static int calculateGraphDepth2(){
        int depth = 0;
        int index = 1;
        Queue<Integer> parentQueue = new LinkedList<>();
        parentQueue.offer(index);
        while( !parentQueue.isEmpty()){
            depth++;
            int parentNum = parentQueue.size();
            while ( parentNum > 0 ){
                int curIndex = parentQueue.poll();
                Node curNode = head[curIndex];
                while( null != curNode.next){
                    parentQueue.offer( curNode.next.value);
                    curNode = curNode.next;
                }
                parentNum--;
            }
        }
        return depth-1;
    }
    /* ͷ�巨 �γɱ��� */
    public static void generateGraph(int parent , int child){
        Node curNode = new Node(child);
        curNode.next  = head[parent].next;
        head[parent].next = curNode;
    }
    /* ����ͷ������ */
    public static void initGraph(int n ){
        head = new Node[n+1];
        for(int i = 0 ;i <=n ;i++){
            head[i] = new Node(i);
        }
    }
    static class Node{
        int value ;
        Node next = null;
        public Node(int value){
            this.value = value;
        }
    }
}
