package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * 237
 * desc: 删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
    }
}
