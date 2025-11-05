package com.maji.maojianwei.leetcode.format.sort;

import com.maji.maojianwei.leetcode.utils.ArrayUtil;

/**
 * 希尔排序：
 */
public class ShellSort {

	public static void shellSort(int[] array) {
		int j;
		//最终 gap == 1
		for(int gap=array.length/2; gap > 0; gap/= 2){
			//对于特定的gap, 分成了 n/gap = g 组, 这g组每个相应的位置组成 gap 组，进行冒泡排序一次完整的遍历
			for(int i = gap; i < array.length; i++){
				int temp = array[i];
				for(j=i; j>=gap && temp < array[j-gap]; j-=gap){
					array[j] = array[j-gap];
				}
				array[j] = temp;
			}
		}
	}

	public static void shellSort2(int[] array){
		int gap = array.length/2;
		while(gap > 0){
			// 一共分成了gap组， 每组元素进行排序（这里选择插入排序）
			for(int i = 0; i<gap; i++){
				for(int j = i+gap; j< array.length; j+=gap){
					int temp = array[j];
					int k = j;
					for(; k >0 && temp < array[ k- gap]; k-= gap){
						array[k] = array[k-gap];
					}
					array[k] = temp;
				}
			}
			ArrayUtil.printArray(array);
			gap /= 2;
		}
	}
}
