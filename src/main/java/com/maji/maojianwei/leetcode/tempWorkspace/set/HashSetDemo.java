package com.maji.maojianwei.leetcode.tempWorkspace.set;
//Set�в������ظ�
import java.util.*;
public class HashSetDemo {

	public static void main(String[] args){
		Set<String> set = new HashSet<>();
		set.add("new york");
		set.add("london");
		set.add("Paris");
		set.add("new york");
		set.add("Beijing");
		set.add("new york");
		System.out.print(set);
		System.out.println();
		for(String s :set) {
			System.out.println(s.toUpperCase());
		}

	}

}
