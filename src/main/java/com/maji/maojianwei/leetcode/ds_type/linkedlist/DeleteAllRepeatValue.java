package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;


/** 删除相同节点， 相同节点一个不留，只留下原来只有一个的节点
 * @author weitong
 * @date 2022/02-19 1:56 下午
 */
public class DeleteAllRepeatValue {

    /**
     * 遍历
     * @param head
     * @return
     */
    public static ListNode delete(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(1000);
        // 三个指针分别指向已处理链表的最后一个节点、待判断的第一个和遍历节点
        ListNode pre = newHead;
        ListNode start = head;
        ListNode cur = head.next;

        while(cur != null){
            while(cur != null && cur.val == start.val){
                cur = cur.next;
            }
            if(cur == null){
                pre.next = null;
            } else if(start.next == cur){
                pre = pre.next;
                start = cur;
                cur = cur.next;
            } else{
                pre.next = cur;
                start =cur;
                cur= cur.next;
            }
        }

        return newHead.next;
    }


}
