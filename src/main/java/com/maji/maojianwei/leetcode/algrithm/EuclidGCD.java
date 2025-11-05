package com.maji.maojianwei.leetcode.algrithm;

import java.util.Scanner;

public class EuclidGCD {
	private static int n=0;
	
	
	public static int gcd(int a ,int b) {
		if(b==0)
			return a;
		else {
			n++;
			return gcd(b,a%b);
		}
			
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count =0;
		while(count<10) {
		
			System.out.println("����������������");
			int a =in.nextInt();
			int b =in.nextInt();
			if(a>b)
				System.out.println("��Լ���ǣ�"+gcd(a,b));
			else
				System.out.println("��Լ���ǣ�"+gcd(b,a) +"�Ƚϴ�����"+n);
		
			count++;
		}
		
		
		

	}

}
