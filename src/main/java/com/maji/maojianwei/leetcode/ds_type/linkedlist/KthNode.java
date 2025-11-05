package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * desc: 找出倒数第k个节点
 */
public class KthNode {


    /**
     * 比较简单的方法是先计算节点数n， 然后走 n - k 即可
     * 也可以使用双指针法，一个先走k步，然后两个指针同时走
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for( int i = 0 ; i< k; i++){
            former = former.next;
        }
        while(former != null){
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }


}
