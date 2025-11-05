package com.maji.maojianwei.leetcode.ds_type.set;

import java.util.LinkedHashMap;

/**
 * 142
 * desc：基于linkedHashMap构造一个 LRU缓存
 */
public class LRUCache2 {
    LinkedHashMap<Integer, Integer> map ;
    int capacity = 0;

    public LRUCache2(int capacity) {
        map = new LinkedHashMap(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer v = map.get(key);
        if(v == null){
            return  -1;
        }
        return v;
    }

    public void put(int key, int value) {
        if(get(key) != -1){
            map.put(key,value);
            return;
        }
        if(map.size() >= capacity){
            final Integer key1 = map.entrySet().iterator().next().getKey();
            map.remove(key1);
        }
        map.put(key, value);
    }
}
