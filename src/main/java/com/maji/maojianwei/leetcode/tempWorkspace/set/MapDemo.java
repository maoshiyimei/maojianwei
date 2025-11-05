package com.maji.maojianwei.leetcode.tempWorkspace.set;
import java.util.*;
public class MapDemo {

	public static void main(String[] args) {
		Map<String,Integer> hashmap =new HashMap<>();//����
		
		hashmap.put("Amily",20);
		hashmap.put("Jack",28);
		hashmap.put("Tom",33);
		hashmap.put("Smith",30);
		System.out.println(hashmap);
		System.out.println(hashmap.get("Tom"));
		//������˳�򴴽�����
		Map<String,Integer> linkedHashmap =new LinkedHashMap<>(16,0.75f,true);
		hashmap.put("Smith",30);
		hashmap.put("Amily",20);
		hashmap.put("Jack",28);
		hashmap.put("Tom",33);
		hashmap.put("Xian",33);
		System.out.println(hashmap);
		System.out.println(linkedHashmap.get("Tom"));//�����⣡����������
		System.out.println(hashmap);
	}

}
