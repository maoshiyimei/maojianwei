package com.maji.maojianwei.leetcode.ds_type.linkedlist;


import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 328
 * desc: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 */
public class ReorganizeList {

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode oddHead = head;
        ListNode oddPre = head;
        ListNode oddCur = head.next.next;
        ListNode evenNHead = head.next;
        ListNode evenPre = head.next;  // 维护两条链表，尾插法更新，最后拼接即可
        ListNode evenCur = oddCur == null ? null : oddCur.next;
        while(oddCur != null){
            oddPre.next = oddCur;
            oddPre = oddCur;
            oddCur = evenCur == null? null : evenCur.next;
            if(evenCur != null){
                evenPre.next  = evenCur;
                evenPre = evenCur;
                evenCur = oddCur == null ? null :oddCur.next;
            }
        }
        oddPre.next = evenNHead;
        evenPre.next = null;
        return oddHead;

    }

    /**
     * 优化代码， 不需要使用尾插法进行，head 和 head.next就是两个头部， 维护两个遍历指针odd even ,后面的关系可以直接用
     */

    // 双指针
    public static ListNode oddEvenList2(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode oddCur = head;
        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;
        ListNode cur = evenCur.next;
        while(cur != null){
            if(cur == evenCur.next){
                oddCur.next = cur;
                oddCur = cur;
            } else {
                evenCur.next = cur;
                evenCur = cur;
            }
            cur = cur.next;
        }
        evenCur.next = null;
        // 将偶数链练到后面
        oddCur.next = evenHead;
        return head;
    }

    /**
     * 代码优化
     * @param head
     * @return
     */
    public static ListNode oddEvenList3(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        ListNode eventHead = head.next;
        // 注意结束条件是偶数指针执向最后一个指针或者空， 这样可以保证奇数指针不会指向空，否则两边都是空就会无法连接
        while(evenCur != null && evenCur.next != null){
            oddCur.next = evenCur.next;
            oddCur = oddCur.next;
            evenCur.next = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = eventHead;
        return head;

    }

    /**
     * 获得两条链表：注意区别
     * @param head
     * @return
     */
    public static List<ListNode> oddEvenList4(ListNode head){
        List<ListNode> res = new ArrayList<>();
        if(head == null){
            return null;
        }
        if(head.next == null){
            res.add(head);
            res.add(null);
            return res;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while(even != null){
            odd.next = even.next;
            odd = odd.next;
            if(odd == null){
                break;
            }
            even.next = odd.next;
            even = even.next;
        }
        res.add(head);
        res.add(evenHead);
        return res;

    }

}
