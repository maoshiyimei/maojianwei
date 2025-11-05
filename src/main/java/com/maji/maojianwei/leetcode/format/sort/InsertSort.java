package com.maji.maojianwei.leetcode.format.sort;

/**
 * 插入排序，每向前走一步，之前的序列都是有序的
 * */

public class InsertSort{
	
	public static void insertSort(int[] array) {
		//第一个不用排序
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;
			for(j = i-1; j >=0 && array[j] > temp; j--) {  // 找到第一个小于等于 temp 的节点，之前的右移动
				array[j+1]= array[j];
			}
			array[j+1]=temp;
		}
	}
	

}
