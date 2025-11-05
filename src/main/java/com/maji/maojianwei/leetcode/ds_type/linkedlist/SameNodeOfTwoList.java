package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * desc: 找到两个链表的第一个公共节点
 */
public class SameNodeOfTwoList {

    /**
     * 借助集合，效率较低
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while(headA != null ){
            listNodeSet.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(listNodeSet.contains(headB)){
                return headB;
            } else{
                headB = headB.next;
            }
        }
        return null;
    }

    /**
     * 双指针的方法比较巧妙： A走完了链表A，然后走链表B， B走完了链表B，然后走链表A，两者刚好在交汇点相遇
     *  （1）假设链表A的长度为 a +  c (c为公共长度）
     *  （2）假设链表B的长度为 b +  c
     *   (3) 两者走的长度都是：  a + b + c
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A != B){
            A = A == null? headB: A.next;
            B = B == null? headA: B.next;
        }
        return A;
    }

    /**
     * 第三种方法： 分别计算两者的长度，长的先走，然后一起边走边比较即可
     */


    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while( a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }



}
