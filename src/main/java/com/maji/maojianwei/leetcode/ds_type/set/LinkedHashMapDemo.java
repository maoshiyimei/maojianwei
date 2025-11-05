package com.maji.maojianwei.leetcode.ds_type.set;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {

		Map<String,Integer> linkedHashmap =new LinkedHashMap<>(16,0.75f,true);
		linkedHashmap.put("Smith",30);
		linkedHashmap.put("Amily",20);
		linkedHashmap.put("Jack",28);
		linkedHashmap.put("Tom",33);
		linkedHashmap.put("Xian",33);

		System.out.println(linkedHashmap);
		linkedHashmap.get("Smith");
		System.out.println(linkedHashmap);
		for(Map.Entry<String , Integer> entry : linkedHashmap.entrySet()){
			System.out.println(entry.getKey() + " : "+ entry.getValue());
		}

		Map<Integer, Integer> map = new ConcurrentHashMap<>();
		String x = "alinisverysfsgd";
		System.out.println(Integer.toBinaryString(x.hashCode()));
		int h = x.hashCode() ^ (x.hashCode() >>> 16);
		System.out.println(Integer.toBinaryString(h));

	}

}
