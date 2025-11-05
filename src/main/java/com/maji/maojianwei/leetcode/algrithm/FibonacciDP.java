package com.maji.maojianwei.leetcode.algrithm;//��̬�滮���쳲�������,���þֲ�����Կ��Բ���ʹ������

import java.util.Scanner;
public class FibonacciDP {
	
	public static void main(String[] args){
		System.out.println("enter a number:");
		Scanner input= new Scanner(System.in);
		System.out.println(fibonacci(input.nextInt()));
		input.close();
	}
	
	public static int fibonacci(int n){
		int f0 = 0;
		int f1 = 1;
		int f2 = 1;
		if(n==0)
			return f0;
		if(n==1)
			return f1;
		if(n==2)
			return f2;
		for(int i =3;i<=n;i++) {
			f0 = f1;
			f1 = f2;
			f2 = f0+f1;
		}
		return f2;
	}

}
