package com.maji.maojianwei.leetcode.tempWorkspace.set;
import java.util.*;

public class CountOccuranceDemo {

	public static void main(String[] args) {
		String text = "Good morning.Have a good class!Have a good visit.Have fun!";
		String[] words =text.split("[ \n\t\r.,;:!?(){}]");
		Map<String,Integer> map =new TreeMap<>();
		for(String s :words) {
			String temp =s.toLowerCase();
			if(temp.length()>0) {
				if(!map.containsKey(temp)) {
					map.put(temp,1);
				}
				else {
					int value =map.get(temp);
					value++;
					map.put(temp,value);
				}
			}
		}
		Set<Map.Entry<String,Integer>> entrySet =map.entrySet();
		for(Map.Entry<String, Integer> entery:entrySet) {
			System.out.println(entery.getKey()+" " + entery.getValue());
		}
		
	}

}
