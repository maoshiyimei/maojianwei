package com.maji.maojianwei.leetcode.algrithm;
/*暴力求解，两重循环，时间复杂度为O（n2) */
public class MaxSubSum_nomal {
	private static int n =20;
	private static int leftFlag=0;//用于标记位置；
	private static int rightFlag=0;
	
	public static void main(String[] args) {
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] =(int)(Math.random()*100)%50 -25;
			System.out.print(array[i]+"  ");
		}
		System.out.println();
		System.out.println("最长子段和"+ maxSubSum(array));
		for(int i =0;i<n;i++) {
			if(i==leftFlag) {
				System.out.print("[ "+array[i]+"  ");
			}
			else if(i == rightFlag) {
				System.out.print(+array[i]+" ]  ");
			}
			else {
				System.out.print(array[i]+"  ");
			}
		}
		int sum=0;
		for(int i =leftFlag;i<=rightFlag;i++) {
			sum+=array[i];
		}
		System.out.println("\n"+sum);

	}
	
	public static int maxSubSum(int[] array) {
		int len=array.length;
		int sum=Integer.MIN_VALUE;
		for(int i =0;i<len;i++) {
			int tempSum =0;
			for(int j =i;j<len;j++) {//两重循环即可，中间其实也用到了局部的动态规划
				tempSum +=array[j];
				if(tempSum>sum) {
					sum =tempSum;
					leftFlag = i;
					rightFlag =j;
				}
			}
		}
		return sum;
	}
}
