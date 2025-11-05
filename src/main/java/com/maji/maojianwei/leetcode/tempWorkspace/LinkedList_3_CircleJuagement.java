package com.maji.maojianwei.leetcode.tempWorkspace;


import com.maji.maojianwei.leetcode.entity.Node;

/**
 * Class: ����ж�һ���������Ƿ��л���
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 15:11
 */
public class LinkedList_3_CircleJuagement {
    public static void main(String[] args){
        Node head1 = getLinkedListWithCircle();
        Node head2 = getLinkedListWithoutCircle();
        System.out.println(judgeCircle(head1));
        System.out.println(judgeCircle(head2));

    }
    /*����ָ��Ĺؼ��ǲ�����һ�£�����*/
    public static boolean judgeCircle(Node head){
        if( head == null || head.next == null || head.next.next == null ){
            return false;
        }
        Node foreNode = head.next;
        Node backNode = head;
        while( foreNode != backNode){
            if( foreNode.next == null || foreNode.next.next == null ||  backNode == null){
                return false;
            }
            else{
                foreNode = foreNode.next.next;
                backNode = backNode.next;
            }
        }
        return true;
    }

    public static Node getLinkedListWithCircle(){
        Node head = new Node(0);
        Node parent = head;
        for( int i= 1; i<= 6 ; i ++){
            Node curNode = new Node(i);
            parent.next = curNode;
            parent = curNode;
        }
        Node temp = parent;
        for( int i= 7; i<= 14 ; i ++){
            Node curNode = new Node(i);
            parent.next = curNode;
            parent = curNode;
        }
        parent.next = temp;
        return head;
    }
    public static Node getLinkedListWithoutCircle(){
        Node head = new Node(0);
        Node parent = head;
        for( int i= 1; i<= 14 ; i ++){
            Node curNode = new Node(i);
            parent.next = curNode;
            parent = curNode;
        }
        return head;
    }
}
