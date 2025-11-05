package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 链表排序：
 * @author weitong
 * @date 2022/02-20 1:31 下午
 */
public class ListSort {


    /**
     * 二分，排序，合并，和数组的归并排序相同
     * @param head
     * @return
     */
    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return  head;
        }
        ListNode mid = findMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        ListNode leftListHead = mergeSort(head);
        ListNode rightListHead = mergeSort(temp);
        ListNode res =mergeTwoOrderedList(leftListHead, rightListHead);
        return res;
    }

    /**
     * 找链表的中间节点（偶数情况左边的）
     * @param head
     * @return
     */
    public static ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 合并两个有序列表：递归算法
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoOrderedList(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.val < head2.val){
            head1.next = mergeTwoOrderedList(head1.next, head2);
            return head1;
        } else{
            head2.next = mergeTwoOrderedList(head1, head2.next);
            return head2;
        }
    }

    /**
     * 快排
     */
    public static ListNode quickSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = partition(head);
        // 左链表为空的情况需要特别判断，不同于数组，
        if(head == p){
            head.next = quickSort(p.next);
            return head;
        }
        ListNode pre = head;
        while(pre.next != p){
            pre =pre.next;
        }
        pre.next = null;
        ListNode leftListHead = quickSort(head);
        ListNode rightListHead = quickSort(p.next);
        // 组装
        ListNode cur = leftListHead;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = p;
        p.next = rightListHead;
        return leftListHead;
    }

    /**
     * 划分：
     * @param head
     * @return
     */
    public static ListNode partition(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // head.val 作为划分值, pre 指向最后一小于比较值的位置， cur遍历指针
        int pivot = head.val;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val < head.val){
                pre = pre.next;
                int temp = pre.val;
                pre.val = cur.val;
                cur.val = temp;
            }
            cur = cur.next;
        }
        head.val = pre.val;
        pre.val = pivot;
        return pre;
    }
}
