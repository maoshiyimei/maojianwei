package com.maji.maojianwei.leetcode.ds_type.linkedlist;


import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * desc: 给定两个用链表表示的整数，每个节点包含一个数位。
         这些数位是反向存放的，也就是个位排在链表首部。
         编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class ListSum {


    /**
     * 逻辑是从头到尾相加就是结果，只要带上进位就行了。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;//求两个节点相加的值
            carry = sum / 10;//取进位的值
            pre.next = new ListNode(sum % 10);//sum对10求余后放到节点中
            pre = pre.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }

    /**
     * 自己写的没有优化
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode parent = root;
        ListNode curNode = null;
        int carry = 0;
        while(l1!=null && l2 !=null){
            int sum = l1.val + l2.val + carry;
            curNode= new ListNode(sum%10 );
            parent.next = curNode;
            parent = curNode;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            curNode = l1;
            int sum = l1.val + carry;
            curNode.val = sum%10;
            parent.next = curNode;
            parent = curNode;
            carry = sum/10;
            l1= l1.next;
        }
        while(l2!=null){
            curNode = l2;
            int sum = l2.val + carry;
            curNode.val = sum%10;
            parent.next = curNode;
            parent = curNode;
            carry = sum/10;
            l2= l2.next;
        }
        if(carry != 0 ){
            curNode = new ListNode(carry);
            parent.next = curNode;
        }
        return root.next;
    }
}
