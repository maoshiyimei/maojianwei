package com.maji.maojianwei.leetcode.ds_type.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentModifyExceptionDemo {
    public static void main(String[] args){

        HashMap<String , Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);
//        for(Map.Entry<String, Integer> entry : map.entrySet()){
//            if(entry.getKey() == "C"){
//                map.remove(entry.getKey());  //报错
//            }
//        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            if(entry.getKey() == "C"){
                it.remove();  //不会报错
            }

        }


        System.out.println(map);

    }
}
