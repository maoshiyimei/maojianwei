package com.maji.maojianwei.leetcode.other.lru;

public class LruTest {

    public static void main(String [] args){
        LruCache cache = new LruCache(5);
        int getValue = cache.get(0);
        System.out.println("get 0: " + getValue);
        cache.put(1, 999);
        cache.put(2, 999);
        cache.put(3, 999);
        cache.put(4, 999);
        cache.put(5, 999);
        cache.print();
        getValue = cache.get(3);
        System.out.println("get 3: " + getValue);
        cache.print();
        cache.put(6, 999);
        cache.print();

        cache.put(2, 888);
        cache.print();

    }
}
