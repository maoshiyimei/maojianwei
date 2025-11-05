package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 83
 * desc : 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 */
public class DeleteRepeatValue {


    /**
     * 两个指针：遍历时如果相同则断链，否则前进
     * @param head
     * @return
     */
    public static ListNode delete1(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!= null){
            if(cur.val == pre.val){
                pre.next = cur.next;
            } else{
                 pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 两个指针：每次都将相同元素找完为止
     */
    public static ListNode delete2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            // 注意为空的情况无需比较值
            while(cur != null && cur.val == pre.val){
                cur = cur.next;
            }

            pre.next = cur;
            pre = cur;
            // 注意这里为空的情况, 停止遍历
            if(cur!= null){
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 递归
     * @param head
     */
    public static ListNode delete3(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode subListHead = delete3(head.next);
        if(subListHead.val == head.val){
            return subListHead;
        } else{
            head.next = subListHead;
            return head;
        }
    }
}
