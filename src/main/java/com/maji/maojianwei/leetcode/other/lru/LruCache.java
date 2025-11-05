package com.maji.maojianwei.leetcode.other.lru;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    private DLinkedNode head;

    private DLinkedNode tail;

    /**
     * 构造方法：初始化两个无业务含义的节点作为链表的头部和尾部节点
     * @param capacity
     */
    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            // 表示不存在
            return -1;
        }

        // 存在则移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        //先查询node
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);

            // 判断是否超过容量限制
            if(size >= capacity){
                removeTail();
            }
            addToHead(newNode);
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 将某个节点移动到头部，
     * @param node
     */
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre= head;
        size++;
    }

    /**
     * 将节点从链表中删除
     * @param node
     */
    private void removeNode(DLinkedNode node){
        if (node == null){
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 删除尾部节点
     * @return
     */
    private void removeTail(){
        int removeKey = tail.pre.key;
        removeNode(tail.pre);
        cache.remove(removeKey);
        size--;
    }

    public void print(){
        DLinkedNode curNode = head.next;
        System.out.println("***********************************");
        while(curNode != tail){
            System.out.println(curNode.key + " : " + curNode.value);
            curNode = curNode.next;
        }
    }




}
