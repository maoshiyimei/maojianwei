package com.maji.maojianwei.leetcode.algrithm;
/*动态规划，自顶向下递归求解,记录已经求解过的子问题，效率提高很多，用时不到1毫秒
 * 以额外的空间节省计算时间，使得指数时间降低为多项式时间*/
import java.util.Arrays;

public class CutRod_DP1 {
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
		if(r[n]>=0) {
			return r[n];//，如果已经有结果了就不用重复计算
		}
		if(n==0) {//递归出口
			r[n]=0;
			return 0;
		}
		else {
			int q = -1;
			for(int i=1;i<=n;i++) {
				int temp = price[i]+cutRod(n-i);
				if(temp>q)
					q=temp;
			}
			r[n] = q;
			return r[n];
			
		}
		
	}

}
