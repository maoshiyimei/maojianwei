package com.maji.maojianwei.leetcode.ds_type.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		set.add("new york");
		set.add("london");
		set.add("Paris");
		set.add("shanghai");
		set.add("new york");


		for(String s :set) {
			System.out.println(s.toUpperCase());
		}

	}

}
