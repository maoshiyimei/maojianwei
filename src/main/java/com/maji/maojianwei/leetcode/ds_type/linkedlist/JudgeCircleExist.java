package com.maji.maojianwei.leetcode.ds_type.linkedlist;


import com.maji.maojianwei.leetcode.entity.ListNode;

/**
 * @author weitong
 * @date 2022/02-17 4:42 下午
 */
public class JudgeCircleExist {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean judge(ListNode head){
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;

    }
}
