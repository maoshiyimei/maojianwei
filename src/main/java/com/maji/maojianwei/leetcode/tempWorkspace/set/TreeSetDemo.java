package com.maji.maojianwei.leetcode.tempWorkspace.set;
import java.util.*;
public class TreeSetDemo {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("new york");
		set.add("london");
		set.add("Paris");
		set.add("new york");
		set.add("Beijing");
		set.add("new york");
		TreeSet<String> treeSet =new TreeSet<>(set);
		System.out.println("sorted treeSet:"+treeSet);
		System.out.println("first()"+treeSet.first());
		System.out.println("Last()"+treeSet.last());
		System.out.println("headSet(\"Paris\")"+treeSet.headSet("Paris"));
		System.out.println("tailSet(\"Paris\")"+treeSet.tailSet("Paris"));
		System.out.println("lower(\"P\")"+treeSet.lower("P"));
		System.out.println("higher(\"P\")"+treeSet.higher("P"));
		System.out.println("floor(\"P\")"+treeSet.floor("P"));
		System.out.println("ceiling(\"P\")"+treeSet.ceiling("P"));
		System.out.println("pollFirst()"+treeSet.pollFirst());
		System.out.println("pollLast()"+treeSet.pollLast());
		System.out.println("now treeSet:"+treeSet);
		
		
	}

}
