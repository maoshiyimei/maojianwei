package com.maji.maojianwei.leetcode.algrithm;

import java.util.Scanner;
public class IntReverseDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			int x = input.nextInt();
			int result=0;
			int push =x;
			while(push!=0) {
				
				int pop = push%10;
				push = push/10;
				result = result*10+pop;
				
			}
			System.out.println(x + ": "+ result);
			if(result == 0)
				break;
		}
		input.close();

	}

}
