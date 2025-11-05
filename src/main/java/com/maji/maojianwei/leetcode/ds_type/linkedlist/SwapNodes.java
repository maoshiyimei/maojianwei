package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 1721
 * desc: 给你链表的头节点 head 和一个整数 k 。交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 */
public class SwapNodes {

    /**
     * 双指针， 一个先走k-1步， 然后另一个开始一起走，这样之后left right 就分别指向两个需要交换的节点，交换val即可
     */
    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode former = head;
        for(int i = 1; i<k ;i ++){
            former = former.next;
        }
        ListNode tmp = former;

        ListNode latter = head;
        while(former.next != null){
            former = former.next;
            latter = latter.next;
        }
        int leftVal = tmp.val;
        tmp.val = latter.val;
        latter.val = leftVal;
        return head;
    }
}
