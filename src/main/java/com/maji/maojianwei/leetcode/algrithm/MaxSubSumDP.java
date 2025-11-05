package com.maji.maojianwei.leetcode.algrithm;
/*	最大字段和，动态规划，最优子结构是：如果累计和已经小于零，则前面已经可以大胆放弃，
 * 遍历一次即可，时间复杂度为O(n) */

public class MaxSubSumDP {

	private static int n = 20;
	private static int leftFlag=0;//用于标记位置；
	private static int rightFlag=0;
	
	public static void main(String[] args){
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] =(int)(Math.random()*100)%50 -25;
			System.out.print(array[i]+"  ");
		}
		System.out.println();
		System.out.println("最长字段和"+ maxSubSum(array));
		for(int i =0;i<n;i++) {
			if(i==leftFlag) {
				System.out.print("[ "+array[i]+"  ");
				if(i==rightFlag) {
					System.out.print(" ]  ");
				}
			}
			else if(i == rightFlag) {
				System.out.print(+array[i]+" ]  ");
			}
			else {
				System.out.print(array[i]+"  ");
			}
		}
		int sum=0;
		for(int i =leftFlag;i<=rightFlag&&i<n;i++) {
			sum+=array[i];
		}
		System.out.println("\n"+sum);
	}
	
	public static int maxSubSum(int[] array) {
		int len =array.length;
		int sum=Integer.MIN_VALUE;
		int temp=0;
		leftFlag = 0;
		for(int i =0;i<len;i++) {
			temp+=array[i];
			if(temp<0){
				temp=0;
				leftFlag = i+1;
				rightFlag=i+1;
			}
				
			if(temp>sum) {
				sum=temp;
				rightFlag=i;
			}
		}
		return sum;

	}
	
	

}
