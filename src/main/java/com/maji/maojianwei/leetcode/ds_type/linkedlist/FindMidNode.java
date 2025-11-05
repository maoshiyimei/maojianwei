package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 876
 * desc:给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
public class FindMidNode {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null){
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    public static ListNode findMid2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }





}
