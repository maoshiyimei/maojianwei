package com.maji.maojianwei.leetcode.algrithm;

import java.util.ArrayList;


/*该算法的功能是，矩形区域中，个元素的值为0，1，2，
 * 对于值为2的情况，可以感染其上下左右的元素中的，使之变成2，
 * 求经过多少时间后，矩阵元素不在不变变化，并判断是否最后还有1；*/
public class ChangeToSame {
	private static int n= 0;
	private static int m = 0;
	private static int[][] matrix=null;
	public static void main(String[] args) {
		n = 6;
		m = 8;
		matrix =new int[n][m];
		for(int i =0;i<n;i++) {
			for(int j =0;j<m;j++) {
				matrix[i][j] = ((int)(Math.random()*100))%3;
			}
		}
		printMatrix();
		int time = change1To2();
		if(contains1()) {
			System.out.println("可以将所有的1转换成2，用时："+time);
		}
		else {
			System.out.println("无法将所有的1转换成2，用时："+time);
		}
		
		
		

	}
	public static int change1To2() { 
		int time =0;
		boolean flag =false;
		while(flag == false) {
			flag =true;
			//Map<Integer,Integer> map = new HashMap<>();
			//不能使用map因为无法存储重复的键
			ArrayList<int[]> list = new ArrayList<>();
			
			for(int i =0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(matrix[i][j] ==2) {
						if( (i-1>=0 && matrix[i-1][j] ==1) ||
							(j-1>=0 && matrix[i][j-1] ==1) ||
							(i+1<n  && matrix[i+1][j] ==1) ||
							(j+1<m  && matrix[i][j+1] ==1) ) {
							flag =false;
							int[] x= new int[2];
							x[0]=i;
							x[1]=j;
							list.add(x);
						}
					}
					
				}
			}
			System.out.println(list);
			for(int[] entry :list) {
				int p = entry[0];
				int q = entry[1];
				if(p-1>=0 && matrix[p-1][q] ==1 ){
					matrix[p-1][q] =2;
				}
				if(q-1>=0 && matrix[p][q-1] ==1 ){
					matrix[p][q-1] =2;
				}
				if(p+1<n && matrix[p+1][q] ==1 ){
					matrix[p+1][q] =2;
				}
				if(q+1<m && matrix[p][q+1] ==1 ){
					matrix[p][q+1] =2;
				}
			}
			list.clear();
			printMatrix();
			time++;
		}
		return time-1;
		
		
	}
	public static boolean contains1() {
		for(int i =0;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(matrix[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	public static void printMatrix() {
		System.out.println("-----------------");
		for(int i =0;i<n;i++) {
			for(int j =0;j<m;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

}
