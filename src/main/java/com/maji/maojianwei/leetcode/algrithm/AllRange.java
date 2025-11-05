package com.maji.maojianwei.leetcode.algrithm;//全排列，N!，采用回溯法，这是基于排列数的回溯算法；

public class AllRange {
	private static int N=3;
	public static void main(String[] args) {
		char[] text= new char[N];
		for(int i =0;i<N;i++) {
			text[i] =(char)((int)(Math.random()*100)%26+97);
		}
		allRange(text,N);
	}
	public static void allRange(char[] text,int n){
		if(n == 1) {
			System.out.println(text);
		}
		else {
			for(int i =0;i<n;i++) {//每一位进行替换
				
				char temp =text[i];//替换
				text[i] = text[n-1];
				text[n-1]= temp;
				
				allRange(text,n-1);//下一个
				
				temp =text[i];//恢复
				text[i] = text[n-1];
				text[n-1]= temp;
			}
		}
	}

}
