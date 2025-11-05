package com.maji.maojianwei.leetcode.algrithm;
/*动态规划，自底向上求解,记录已经求解过的子问题，仅计算一遍，效率提高很多，用时不到1毫秒
 * 以额外的空间节省计算时间，使得指数时间降低为多项式时间，
 * 相比于自顶向下的方法更加优化，虽然数量级是一样的
 * 因为实际上没有使用递归方法，最终问题一定是在子问题解决之前才执行*/
import java.util.Arrays;

public class CutRod_DP2 {
	private static int[] price ={0,
			1,5,8,9,10,17,19,20,24,30,
			35,40,47,50,58,60,69,70,80,85,
			89,90,94,95,100
			};
	private static int[] r = new int[25];
	public static void main(String[] args) {
		int n =24;
		Arrays.fill(r, -1);
		long start = System.currentTimeMillis();
		int best = cutRod(n);
		long end = System.currentTimeMillis();
		System.out.println(n+": "+best);
		System.out.println("time :"+(end-start)+" ms");
	}
	public static int cutRod(int n) {
		r[0]=0;
		for(int i =1;i<=n;i++) {
			int q =-1;
			for(int j =1;j<=i;j++) {
				int temp = price[j]+r[i-j];
				if(temp>q)
					q=temp;
			}
			r[i]=q;
		}
		return r[n];
	}

}
