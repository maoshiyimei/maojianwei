package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 92
 * desc: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseListBetween {

    /**
     * 先找到第一个需要倒置的节点， 然后使用头插法新建一个头节点， 倒置完了以后就整体加上去
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        int i = 1;
        while(i++ < left){
            pre = cur;
            cur = cur.next;
        }
        // 需要新建一个头节点来方便进行逆转， 同时需要保存第一个节点因为最后需要连接剩余
        ListNode tempHead = new ListNode(0);
        ListNode endNode = cur;
        for(;i <= right; i++){
            ListNode temp = cur.next;

            cur.next = tempHead.next;
            tempHead.next = cur;

            cur = temp;
        }
        endNode.next = cur;
        pre.next = tempHead.next;

        return newHead.next;

    }
}
