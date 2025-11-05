package com.maji.maojianwei.leetcode.java_language.java8;

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args){
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "doudou");
        map.put(3, "playing");
        map.put(2, "loves");
        map.put(4, "ball");

        /**
         * 结果是按照可以排序的，
         */
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for(Map.Entry<Integer, String> entry : set){
            System.out.println(entry.getValue());
        }

        /**
         * 借助工具类方法可以改成线程安全的
         */
        SortedMap res = Collections.synchronizedSortedMap(map);



    }
}
