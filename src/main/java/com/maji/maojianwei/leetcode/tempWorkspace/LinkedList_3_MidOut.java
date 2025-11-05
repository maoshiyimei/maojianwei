package com.maji.maojianwei.leetcode.tempWorkspace;



import com.maji.maojianwei.leetcode.entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: ������м������
 * ���磺 1->2->3->4->5->6->7  =>  4->3->5->2->6->1->7
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/24 , 18:28
 */
public class LinkedList_3_MidOut {

    public static void main(String[] args){
        int n = 9;
        Node head = new Node(1);
        Node parentNode = head;
        Node curNode = parentNode.next;
        for( int i = 2 ;i <= n ; i++ ){
            curNode = new Node(i);
            parentNode.next = curNode;
            parentNode = curNode;
        }
        Node newNode = outputByMid( head);
        printList(newNode);
    }
    public static Node outputByMid(Node head){
        List<Integer> list = new ArrayList<>();
        while(head!= null){
            list.add(head.value);
            head = head.next;
        }
        int n = list.size();
        Node newHead = new Node(0);
        Node parentNode = newHead;
        if( n % 2 == 1){
            int mid = n/2 ;
            for( int i = 0 ;i < n ;i ++ ){
                mid += i*Math.pow(-1, i );
                Node  curNode = new Node(list.get(mid));
                parentNode.next = curNode;
                parentNode = curNode;
            }
        }
        else{
            int mid = n/2 -1 ;
            for( int i = 0 ;i < n ;i ++ ){
                mid += i*Math.pow(-1, i+1 );
                Node  curNode = new Node(list.get(mid));
                parentNode.next = curNode;
                parentNode = curNode;
            }
        }
        return newHead.next;

    }

    public static void printList(Node head){
        Node curNode = head;
        while( null != curNode ){
            System.out.print( curNode.value + "  ->  ");
            curNode = curNode.next;
        }
    }

}

