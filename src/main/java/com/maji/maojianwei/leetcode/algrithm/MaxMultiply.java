package com.maji.maojianwei.leetcode.algrithm;

public class MaxMultiply {

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
        
        int temp =Integer.MIN_VALUE;
        int max = temp;
        int i =0;
        while(i<nums.length){
            
            temp=nums[i];
            int j=i+1;
            while(j<nums.length){
                temp*=nums[j];
                if(temp>max)
                    max = temp;
            }
            i++;
        }
        return max;
    }

}
