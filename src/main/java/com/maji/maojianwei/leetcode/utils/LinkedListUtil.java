package com.maji.maojianwei.leetcode.utils;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author weitong
 * @date 2022/02-17 6:57 下午
 */
public class LinkedListUtil {

    public static ListNode generateLinkedList(int size){
        if(size < 0){
            return null;
        }
        ListNode head = new ListNode((int)( Math.random()*100));
        size--;
        ListNode p = head;
        while(size != 0){
            p.next = new ListNode((int)( Math.random()*100));
            p = p.next;
            size--;
        }
        return head;
    }

    public static ListNode generateListByArray(int[] array){
        if(array.length  <= 0){
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for(int i = 1; i< array.length; i++){
            ListNode p = new ListNode(array[i]);
            cur.next = p;
            cur = p;
        }
        return head;
    }



    public static void print(ListNode head){
        ListNode p = head;
        while(p != null){
            if(p.next == null){
                System.out.println(p.val);
            } else{
                System.out.print(p.val + " -> ");
            }
             p = p.next;
        }
    }

    public static void printReverse(ListNode head){
        ListNode newHead = new ListNode(0);
        while(head != null){
            ListNode p = new ListNode(head.val);
            p.next = newHead.next;
            newHead.next = p;
            head = head.next;
        }
        print(newHead.next);
    }

}
