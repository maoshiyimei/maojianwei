package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/** 合并两个链表：交叉合并
 * 1 2 3 4
 * 5 6 7
 * -> 1 5 2 6 3 7 4
 * @author weitong
 * @date 2022/02-19 6:45 下午
 */
public class InterceptionMergeList {

    /**
     * 递归算法：
     * @param head1
     * @param head2
     */
    public static ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode subListHead = merge(head1.next, head2.next);
        head1.next = head2;
        head2.next = subListHead;
        return head1;
    }

    /**
     * 简单遍历
     */
    public static ListNode merge2(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        // 尾插法构建新的链表
        ListNode newHead = new ListNode(0);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = newHead;
        while(cur1 != null && cur2 != null){
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
            cur.next = cur2;
            cur2 =cur2.next;
            cur = cur.next;
        }
        if(cur1 != null){
            cur.next = cur1;
        }
        if(cur2 != null){
            cur.next = cur2;
        }
        return newHead.next;
    }

    /**
     * 代码优化：使用一个遍历指针
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode merge3(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode next = head1.next;
        ListNode cur = head2;
        head1.next =cur;
        while(next != null){
            ListNode temp = cur.next;
            cur.next = next;
            cur = next;
            next = temp;
        }
        return head1;
    }



}
