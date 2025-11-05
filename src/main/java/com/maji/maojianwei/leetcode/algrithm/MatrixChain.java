package com.maji.maojianwei.leetcode.algrithm;
/*暴力求解，效率很低，重复的子问题结构,时间为*/
public class MatrixChain {
	private static int N = 20;
	private static int[] p = {5,10,3,12,5,50,6,7,10,20,28,2,12,5,3,12,23,33,2,12,2,};
	//private static int[][] m = new int[N+1][N+1];
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int result = matrixChainOrder(p,1,N);
		long end = System.currentTimeMillis();
		System.out.println(result+",time cost:"+(end-start)+" ms");
	}
	public static int matrixChainOrder(int[] p,int i,int j) {
		if(i==j) {//递归出口
			return 0;
		}
		int pn=Integer.MAX_VALUE;
		for(int k =i;k<=j-1;k++) {//子问题求解
			int temp = matrixChainOrder(p,i,k)+matrixChainOrder(p,k+1,j)+p[i-1]*p[k]*p[j];
			if(temp<pn)
				pn=temp;
		}
		return pn;
		
		
	}

}
