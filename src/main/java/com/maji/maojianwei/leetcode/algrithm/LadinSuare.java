package com.maji.maojianwei.leetcode.algrithm;
import java.util.*;
//拉丁方设计，奇数情况，1-n2
public class LadinSuare {
	public static int[][] square;

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
		while(n%2 == 0) {
			System.out.println("请重新输入一个奇数");
			n = in.nextInt();
		}
		square= new int[n][n];
		for(int i= 0;i<n;i++) {//初始化！
			for(int j =0;j<n;j++) {
				square[i][j] = 0;
			}
		}
		formSquare(n);
		System.out.println("结果为：");
		printSquare(n);
	}
	public static void printSquare(int n) {
		for(int i =0;i<n;i++) {
			for(int j =0;j<n;j++) {
				System.out.print(" | "+square[i][j]);
			}
			System.out.println(" |");
		}
	}
	public static void formSquare(int n) {
		int i = 0;
		int j = n/2;
		int k =1;
		square[i][j]=k;
		k=2;
		int max= n*n;
		while(k<=max){
			if(i==0) {
				if(j==n-1) {
					i=i+1;
				}
				else {
					i=n-1;
					j++;
				}	
			}
			else if(j==n-1) {
				i--;
				j=0;
			}
			else {
				j++;
				i--;
			}
			if(square[i][j] == 0) {
				square[i][j] =k;
				k++;
			}
			else if(i<n-1 && square[i+1][j] == 0){
				square[i+1][j] =k;
				k++;
				i=i+1;
			}
			else {
				i++;
			}
		}
	}

}
