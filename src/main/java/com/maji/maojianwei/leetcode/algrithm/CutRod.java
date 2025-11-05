package com.maji.maojianwei.leetcode.algrithm;
/*暴力求解，自顶向下递归求解,重复计算了很多子问题，效率很差，用时33秒*/
public class CutRod {
	private static int[] price ={0,
			1,5,8,9,10,17,19,20,24,30,
			35,40,47,50,58,60,69,70,80,85,
			89,90,94,95,100
			};

	public static void main(String[] args) {
		int n =24;
		long start = System.currentTimeMillis();
		int best = cutRod(n);
		long end = System.currentTimeMillis();
		System.out.println(n+": "+best);
		System.out.println("time :"+((end-start)/1000)+" s");
	}
	public static int cutRod(int n) {
		if(n == 0)
			return 0;
		int i =1;
		int q = price[1]+cutRod(n-1);
		for(;i<=n;i++) {
			int temp = price[i]+cutRod(n-i);
			if(temp >q)
				q=temp;
		}
		return q;
	}

}
