package com.maji.maojianwei.leetcode.algrithm;

public class MaxMultiplyDemo {

	public static void main(String[] args) {
		int[] nums = new int[10];
		for(int i =0;i<10;i++) {
			nums[i] = (int)(Math.random()*10) - 5;
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		System.out.println("\n最大连续乘积为："+maxProduct(nums));
	}
	public static int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		int n = nums.length;
		for(int i =1;i<n;i++) {
			int temp= max;
			max= Math.max(max*nums[i], min*nums[i]);
			max= Math.max(max,nums[i]);
			min= Math.min(min*nums[i], temp*nums[i]);
			min= Math.min(min,nums[i]);
			result =Math.max(max, result);
		}
		return result;
	}

}
