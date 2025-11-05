package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;


/**
 * 142
 * desc: 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *       将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *       给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class InterceptionReverseList {
    /**
     * 相当于穿线重排: 先找到中点，划分为两个链表， 右边链表倒置， 然后逐个链接即可，
     */
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode head2 = reverseList(mid.next);
        mid.next = null;
        return merge(head, head2);
    }

    /**
     * 找到中点: 如果是偶数，得到的左边的中点
     * @param head
     * @return
     */
    public static ListNode findMidNode(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
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

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // 无须保存next节点，但是head.next的最后设置为空是必要的。
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 交叉合并： 递归法
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode subList = merge(head1.next, head2.next);
        head1.next = head2;
        head2.next = subList;
        return head1;
    }

}
