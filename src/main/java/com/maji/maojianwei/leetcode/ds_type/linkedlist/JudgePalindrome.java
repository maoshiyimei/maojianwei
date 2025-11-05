package com.maji.maojianwei.leetcode.ds_type.linkedlist;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 234. 回文链表
 * 简单
 * 1.8K
 * 相关企业
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class JudgePalindrome {
    private  ListNode preNode;

    /**
     * 先遍历，然后存储在数组中判断
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> data = new ArrayList<>();
        ListNode curNode = head;
        while(curNode != null){
            data.add(curNode.val);
            curNode = curNode.next;
        }
        for (int i = 0 , j = data.size()-1; i<j; i++, j--) {
            if(data.get(i) != data.get(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 递归： 需要借助一个全局变量， 因为递归的遍历顺序是相反的， 所以可以利用递归栈来同时判断正向和反向位置的一致性，从而判断回文
     */


    public boolean isPalindrome2(ListNode head) {
        if(head == null){
            return true;
        }
        preNode = head;

        return true;



    }
    public boolean check(ListNode curNode) {
        // 递归出口
        if (curNode == null) {
            return true;
        }
        // 递归调用
        if (!check(curNode.next)) {
            return false;
        }
        // 处理当前位置
        if(curNode.val != preNode.val) {
            return false;
        }
        // ？？？？
        preNode = preNode.next;


        return true;
    }

    /**
     * 方案3 ： 先逆转后半部分，然后比较
     */


}
