package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 中等
 * 2.1K
 * 相关企业
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {
    /**
     * 递归算法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next= head;
        return newHead;
    }

    /**
     * 非递归算法
     */

    public ListNode swapPairs2(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode preNode = tempHead;
        ListNode curNode = head;

        while(curNode != null && curNode.next != null) {
            //交换curNode 和curNode.next
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            preNode.next = nextNode;
            preNode = curNode;
            curNode = preNode.next;
        }

        return tempHead.next;

    }


}
