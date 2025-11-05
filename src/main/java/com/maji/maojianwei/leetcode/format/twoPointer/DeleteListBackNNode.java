package com.maji.maojianwei.leetcode.format.twoPointer;

import com.maji.maojianwei.leetcode.entity.ListNode;

/**给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @Author maojianwei
 * @Date 2020/8/10 17:39
 **/
public class DeleteListBackNNode {

    /*  快慢指针，快指针先走n节点， 然后一起走完，慢指针下一个就是需要删除的节点
    * 不过需要注意，本质上依然是量变遍历，没有区别，效率上也差不多，奇技淫巧而已 */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(i< n){
            fast = fast.next;
            i++;
        }
        if(fast == null){  //特殊情况，删除首节点
            return head.next;
        }
        while(fast.next != null){
            slow =slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


}
