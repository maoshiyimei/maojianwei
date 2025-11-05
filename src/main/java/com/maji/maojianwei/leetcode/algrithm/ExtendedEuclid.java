package com.maji.maojianwei.leetcode.algrithm;
import java.util.Scanner;

public class ExtendedEuclid {
	private static int n=0;
	private static int d=0;
	private static int x;
	private static int y;
	
	public static void extendedGcd(int a ,int b) {
		if(b==0) {
			d=a;
			x=1;
			y=0;
		}
		else {
			extendedGcd(b,a%b);
			int temp =x;
			x= y;
			y = temp-a/b*y;
		}	
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count =0;
		while(count<10) {
		
			System.out.println("����������������");
			int a =in.nextInt();
			int b =in.nextInt();
			if(a>b) {
				extendedGcd(a,b);
				System.out.println("��Լ���ǣ�"+d +"= gcd("+a+","+b+")="+x+"*"+a+" + "+y+"*"+b);
			}
			else {
				extendedGcd(b,a);
				System.out.println("��Լ���ǣ�"+d +"= gcd("+b+","+a+")="+x+"*"+b+" + "+y+"*"+a);
			}
			count++;
		}
		
		
		

	}

}

