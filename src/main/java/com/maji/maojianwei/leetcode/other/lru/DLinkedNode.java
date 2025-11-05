package com.maji.maojianwei.leetcode.other.lru;

public class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
    public DLinkedNode(){};

    public DLinkedNode(int _key, int _value){
        this.key = _key;
        this.value = _value;
    }
}
