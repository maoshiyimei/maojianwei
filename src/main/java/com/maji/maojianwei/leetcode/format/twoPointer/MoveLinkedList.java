package com.maji.maojianwei.leetcode.format.twoPointer;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * @Author maojianwei
 * @Date 2020/8/13 14:23
 **/
public class MoveLinkedList {
    /* 双指针，首先获得链表长度，然后新节点为倒数 k%n，尾部节点连接到头结点即可，*/
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        /* 找到链表长度和尾部节点*/
        int n = 0;
        ListNode tail = head;
        while(tail.next != null ){
            tail =tail.next;
            n++;
        }
        n++;

        int step = k%n;
        if(step == 0){
            return head;
        }
        /* 找到新的头结点以及其父节点 */
        ListNode newHead = head;
        ListNode parentNode = null;
        for( int i = 0 ;i < n-step ;i++){
            parentNode = newHead;
            newHead = newHead.next;
        }
        parentNode.next = null;
        tail.next = head;
        return newHead;
    }

}
