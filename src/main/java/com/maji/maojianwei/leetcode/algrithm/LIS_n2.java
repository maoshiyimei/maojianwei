package com.maji.maojianwei.leetcode.algrithm;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS_n2 {
	private static int N =10;

	public static void main(String[] args) {
		int[] array = new int[N];
		int[] rArray= new int[N];
		for(int i =0;i<N;i++) {
			array[i] = (int)(Math.random()*20);
			System.out.print(array[i]+" ");
			rArray[i] = array[i];
		}
		System.out.println();
		Arrays.sort(rArray);
		int[] lcs = Lcs(array,rArray);
		for(int i =0;i<lcs.length;i++) {
			System.out.print(lcs[i]+" ");
		}
		
	}
	public static int[] Lcs(int[] a,int[] b) {
		int n =a.length;
		int m =b.length;
		int[][] c =new int[n+1][m+1];
		int[][] f = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			c[i][0]=0;
		for(int j =0;j<=m;j++)
			c[0][j]=0;
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=m;j++) {
				if(a[i-1] == b[j-1]) {
					c[i][j] = c[i-1][j-1]+1;
					f[i][j] = 3;
				}
				else if(c[i-1][j] > c[i][j-1]) {
					c[i][j] = c[i-1][j];
					f[i][j] = 2;
				}
				else {
					c[i][j] = c[i][j-1];
					f[i][j] = 1;
				}
			}
		}
		ArrayList<Integer> lcs = new ArrayList<Integer>();
		int i=n;
		int j=m;
		while(i>0 && j>0) {
			if(f[i][j] == 3) {
				lcs.add(a[i-1]);
				i--;
				j--;
			}
			else if(f[i][j] == 2) {
				i--;
			}
			else {
				j--;
			}
		}
		int k = c[n][m];
		int[] result = new int[k];
		for(i=0;i<k;i++) {
			result[i] = lcs.get(k-i-1);
		}
		return result;
	}

}
