package com.maji.maojianwei.leetcode.algrithm;

public class MatrixChain_DP {
	private static int N = 20;
	private static int[] p = {5,10,3,12,5,50,6,7,10,20,28,2,12,5,3,12,23,33,2,12,2,};
	private static int[][] m = new int[N+1][N+1];
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		matrixChainOrder(1,N);
		int result = m[1][N];
		long end = System.currentTimeMillis();
		System.out.println(result+",time cost:"+(end-start)+" ms");
	}
	public static void matrixChainOrder(int i,int j) {
		for(int k=i;k<=j;k++) {//计算长度为1 的子问题
			m[k][k]=0;
		}
		for(int len =2;len<=j-i+1;len++) {//依次计算长度为2、3、4...N的子问题
			for(int k =i;k<=j-len+1;k++) {//每个长度的子问题的个数，每一个都要求解
				int qn = Integer.MAX_VALUE;
				for(int l=k;l<k+len-1;l++){//在len长度内进行求解，依据已经求解的子问题
					//注意这里的l不能取到等号；
					int temp = m[k][l]+m[l+1][k+len-1]+p[k-1]*p[l]*p[k+len-1];
					if(temp<qn)
						qn=temp;
				}
				m[k][k+len-1]=qn;
				
			}
		}
	}

}
