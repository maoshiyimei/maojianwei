package com.maji.maojianwei.leetcode.java_language.java8;


import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args){
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"1");
        print(linkedHashMap);
        linkedHashMap.put(2,"2");
        print(linkedHashMap);
        linkedHashMap.put(3,"3");
        print(linkedHashMap);
        linkedHashMap.put(4,"4");
        print(linkedHashMap);
        linkedHashMap.put(5,"5");
        print(linkedHashMap);
        linkedHashMap.put(2, "2.0");
        print(linkedHashMap);
        linkedHashMap.put(1, "1.0");
        print(linkedHashMap);
        // 修改已经存在的key是不会影响顺序的
        linkedHashMap.remove(2);
        print(linkedHashMap);
        linkedHashMap.remove(5);
        linkedHashMap.put(6, "6");
        print(linkedHashMap);
        linkedHashMap.remove(1);
        linkedHashMap.put(1, "1");
        print(linkedHashMap);
        System.out.println("-------------------------------------------------");
        // 访问排序
        linkedHashMap = new LinkedHashMap<Integer, String>(10, 0.75f, true);
        linkedHashMap.put(1, "1");
        linkedHashMap.put(2, "2");
        linkedHashMap.put(3, "3");
        linkedHashMap.put(4, "4");
        print(linkedHashMap);
        linkedHashMap.get(3);
        print(linkedHashMap);
        linkedHashMap.remove(1);
        linkedHashMap.get(2);
        print(linkedHashMap);
        linkedHashMap.put(4, "4");
        print(linkedHashMap);




    }

    public static void print(LinkedHashMap<Integer, String> linkedHashMap){
        for(Map.Entry<Integer, String > entry: linkedHashMap.entrySet()){
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }
}
