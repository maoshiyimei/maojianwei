package com.maji.maojianwei.leetcode.algrithm;//时间复杂度依然是n2

public class LIS {
	private static int N=10;

	public static void main(String[] args) {
		int[] array = new int[N];
		for(int i =0;i<N;i++) {
			array[i]= (int)(Math.random()*100);
			System.out.printf("%3d", array[i]);
		}
		System.out.println();
		lis(array);
	}
	
	public static void lis(int[] array) {
		int[] result = new int[array.length];
		for(int i =0;i<array.length;i++) {
			result[i]=-1;
		}
		int k=0;
		int i=0;
		result[k] =array[i];
		for(i=1;i<array.length;i++) {
			if(array[i]>result[k]) {
				k++;
				result[k] = array[i];
			}
			else if(array[i] == result[k])
				continue;
			else {
				int j =k;
				while(result[j]>array[i] && j>0)
					j--;
				result[j] = array[i];
			}
		}
		k=0;
		int count=0;
		while(result[k]!=-1) {
			count++;
			System.out.printf("%3d",result[k]);
			k++;
		}
		System.out.println("最长递增子序列"+count);
	}

}
