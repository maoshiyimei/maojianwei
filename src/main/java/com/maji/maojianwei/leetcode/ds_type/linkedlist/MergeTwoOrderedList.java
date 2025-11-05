package com.maji.maojianwei.leetcode.ds_type.linkedlist;


import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 21
 * desc: 合并两个有序链表
 */
public class MergeTwoOrderedList {

    /**
     * 递归算法
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
        if(head1.val < head2.val){
            head1.next = merge(head1.next, head2);
            return head1;
        } else{
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }

    /**
     * 非递归遍历：两个遍历指针
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode merge2(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = newHead;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur =cur.next;
        }
        if(cur1 != null){
            cur.next = cur1;
        } else{
            cur.next = cur2;
        }
        return newHead.next;
    }

}
