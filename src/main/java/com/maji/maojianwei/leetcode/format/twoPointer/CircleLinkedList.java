package com.maji.maojianwei.leetcode.format.twoPointer;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @Author maojianwei
 * @Date 2020/8/11 18:06
 **/
public class CircleLinkedList {

    /*双指针，快慢指针：
    * （1）快指针两步一次，慢指针一步一次， 必然在环中相遇：
    * 假设 单链为a, 环为b
    * 慢指针走了s ,快指针走了 f
    * f = 2s
    * f = s + nb ，考虑到相遇，必然快指针多跑整数倍的圈 ， n 未知 n >=1
    * 所以 s = nb ********关键
    * 同时可以分析得到： s = a + k + (n-1)b, k表示相遇点距离入口长度
    * 则有 a + k = b
    * 所以让快指针回到头结点，再走a 慢指针在环内也走a, 两人必然在入口相遇
    * */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    /* 哈希方式 :存储访问过的所有节点， 简单但是效率较低，只是耗内存而已 空间换时间*/
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

}
