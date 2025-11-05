package com.maji.maojianwei.leetcode.algrithm;

public class ActivityArrangement {
	private static int [] s = {1,3,0,5,3,5,6,8,8,2,12};
    private static int [] f = {4,5,6,7,8,9,10,11,12,13,14};//已经排序好了
    private static boolean[] a = new boolean[s.length];

	public static void main(String[] args) {
		for(int i =0;i<s.length;i++)
			System.out.println("activity "+i+": "+s[i]+" -> "+f[i]);
		System.out.println("-----------------------");
		activityArrangement();
		for(int i =0;i<s.length;i++) {
			if(a[i]) {
				System.out.println("activity "+i+": "+s[i]+" -> "+f[i]);
			}
		}
	}
	public static void activityArrangement() {
		int x=0;
		a[x] = true;//最早结束的一定是第一个；
		for(int i =1;i<s.length;i++) {
			if(s[i]>=f[x]) {
				a[i]=true;
				x=i;
			}
		}
	}

}
