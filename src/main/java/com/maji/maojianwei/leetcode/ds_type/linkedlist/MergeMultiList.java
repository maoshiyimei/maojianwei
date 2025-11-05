package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 23
 * desc: 合并多个升序列表为一个有序列表
 * 分析时间复杂度的时候假设 每个链表的长度均为 n , 共有 k 个链表
 */
public class MergeMultiList {

    /**
     * 合并两个有序链表： 时间复杂度为 2n  ->  O（n)  空间常量
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null){
            return (list1 == null)? list2 : list1;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode l1 = list1,l2 = list2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return head.next;
    }

    /**
     * 如果直接两两合并：需要合并  k-1 次
     * 时间为 2n + 3n + 4n + 5n + 6n ...+ kn  O(n * k * k )
     * 如果分治法合并： 需要合并总次数也是 k-1 次， 但是二分次数为logK
     * 时间为 2n * (k/2) +  4n * (k/4) + 8n * (k/8) ... O(n * k * logK)
     * 先二分法两两合并,假设有5个链表，
     *              （1 + 2） ->t1
     *               (t1 + 3) -> t2
     *               (5 + 4 ) -> t3
     *               (t2 + t3) -> t4
     * 合并的次数为4次， 比按次序进行合并而言，代价更小， 比较次数更少
     */
    public static ListNode merge(ListNode[] lists,int left, int right){
        if(left > right ){
            return null;
        }
        if(left == right){
            return lists[left];
        }
        int mid = left + (right -left)/2;

        return mergeTwoLists(merge(lists, left, mid), merge(lists,mid + 1, right));
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        return merge(lists,0,lists.length - 1);
    }


    /**
     * 效率较低的简单方法，集合，每次找到最小的然后递归加入到新链表中  不推荐
     * 时间上： 每次比较 k , 总共 kn 次， O(n * k * k) ,主要是涉及集合测操作较慢
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if(n==0){
            return null;
        }
        if(n == 1){
            return lists[0];
        }
        Set<ListNode> nodes = new HashSet<>();
        for(ListNode node : lists){
            if(node != null){
                nodes.add(node);
            }
        }
        if(nodes.size() == 0){
            return null;
        }
        return genOrderedList(nodes);
    }
    public static ListNode genOrderedList(Set<ListNode> nodes){
        // 只有一个直接返回
        if(nodes.size() == 1){
            for(ListNode node :nodes){
                return node;
            }
        }
        // 找到最小值
        int min = Integer.MAX_VALUE;
        ListNode minNode = null;
        for(ListNode node : nodes){
            if(node.val < min){
                min = node.val;
                minNode = node;
            }
        }
        // 拿掉最小值后，递归重新寻找
        nodes.remove(minNode);
        if(minNode.next != null){
            nodes.add(minNode.next);
        }
        minNode.next = genOrderedList(nodes);
        return minNode;
    }

    /**
     *借助堆来完成遍历, 小根堆，每次都是最小的，这样可以显著提高效率
     * 时间上： 每次调整堆获得时间复杂度为 logK, O(n * k * logK)
     */
    public static ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length <= 0){
            return null;
        }

        // 默认就是小根堆:
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 全部头节点入堆
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                queue.offer(lists[i]);
            }
        }

        ListNode newHead = null;
        ListNode cur = null;
        while (!queue.isEmpty()) {
            if (queue.peek().next != null)
                queue.offer(queue.peek().next);
            if (newHead == null) {     // 这里不必要先poll()再add(）是因为链表是升序的，不会是root,
                newHead = new ListNode(queue.poll().val);
                cur = newHead;
            } else {
                cur.next = new ListNode(queue.poll().val);
                cur = cur.next;
            }
        }
        return newHead;
    }
}
