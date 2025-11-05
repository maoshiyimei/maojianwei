package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 876
 * desc:给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第一个中间结点。
 */
public class FindMidNode2 {

    /**
     * 快慢指针， 一个走两步一个走一步
     */
    public static ListNode  middleNode(ListNode head) {
        if(null == head){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow =slow.next;
        }
        return slow;
    }

    public static ListNode  middleNode2(ListNode head) {
        if(null == head){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast.next == null || fast.next.next == null){
                return slow;
            }
            fast = fast.next.next;
            slow =slow.next;
        }
    }

}
