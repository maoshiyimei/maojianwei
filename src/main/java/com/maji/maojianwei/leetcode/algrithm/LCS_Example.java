package com.maji.maojianwei.leetcode.algrithm;

import java.util.Scanner;

/*输入两个字串，可以通过删除或则添加，修改（替换）等方法来使得最终两个字符串一样，问最小的操作数
 * 可以先求最大公共子序列，然后，补齐即可；*/
public class LCS_Example {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		String s1 =in.nextLine();
		String s2 =in.nextLine();
		in.close();
		System.out.println("s1: "+s1);
		System.out.println("s2: "+s2);
		String s = Lcs(s1,s2);
		System.out.println("lcs: "+s);
		System.out.println("need ops:"+Math.max(s1.length()-s.length(),s2.length()-s.length()));
	}
	public static String Lcs(String s1,String s2){
		int n = s1.length();
		int m = s2.length();
		int[][] c =new int[n+1][m+1];
		int[][] b = new int[n+1][m+1];
		for(int i =0;i<=n;i++) {
			c[i][0]=0;
		}
		for(int j =0;j<=m;j++) {
			c[0][j]=0;
		}
		for(int i =1;i<=n;i++){
			for(int j =1;j<=m;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=3;
				}
				else if(c[i-1][j] >c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i][j] = 2;
				}
				else {
					c[i][j] = c[i][j-1];
					b[i][j] = 1;
				}
			}
		}
		StringBuilder result= new StringBuilder();
		int i =n;
		int j =m;
		while(n>0 && j>0) {
			if( b[i][j] == 3){ 
				result.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if( b[i][j] == 2) {
				i--;
			}
			else {
				j--;
			}
		}
		return result.reverse().toString();
	}

}
