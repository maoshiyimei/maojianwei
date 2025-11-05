package com.maji.maojianwei.leetcode.tempWorkspace.set;
import java.util.*;
//LinkedHashSet ��������˳����ʾ
public class LinkedHashSetDemo {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
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
