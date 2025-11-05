package com.maji.maojianwei.leetcode.ds_type.array;

import com.maji.maojianwei.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: 约瑟夫环
 * 循环链表的话时间复杂度比较大（O(NM) ) ;
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/16 , 23:12
 */
public class JosephRing {

    public static void main(String[] args){
        int n = 8 ;
        josephRing1(n,3);
        josephRing2(n,3);
    }
    /* i 表示从哪一位开始报数，默认上次为0 */

    public static void josephRing1(int n ,int m ){

        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i<= n ; i++){
            list.add(i);
        }
        int i = 0;
        System.out.println();
        while(!list.isEmpty()){
            i = (i+m-1)%list.size();        //每次删除的为 i = （ i + m - 1) % 剩余节点
            System.out.print(list.get(i) + " ");
            list.remove(i);
        }
    }

    /**
     * 环形链表
     */
    public static void josephRing2(int n ,int m ){

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i<= n ; i++){
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
        cur.next = head; // 成环
        ListNode pre = cur;
        cur = head;
        System.out.println();
        while(cur != pre){      // 出口
            for( int i = 1 ;i< m; i++){
                cur = cur.next;
                pre = pre.next;
            }
            System.out.print(cur.val + " ");
            pre.next = cur.next;
            cur = pre.next;
        }
        System.out.print(cur.val + " ");
    }
}
