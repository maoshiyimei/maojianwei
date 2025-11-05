package com.maji.maojianwei.leetcode.format.sort;

/**
 * 快速排序
 */
public class QuickSort {

	/**
	 * 排序接口
	 * @param array
	 */
	public static void quickSort(int[] array){
		quickSort(array, 0, array.length-1);
	}

	/**
	 * 分治法: 注意位置p后续不参与排序比较，已经是最终位置！
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array, int left, int right){
		if(left < right){
			int p = partition(array, left, right);
			quickSort(array, left, p-1);
			quickSort(array, p+1, right);
		}
	}

	/**
	 * 分治位置确定:
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int[] array, int left, int right){
		//遍历指针
		int i = left;
		//最近一个小与比较值的位置
		int j = left-1;
		// 比较值选择最右值:这个值不会参与交换，最后需要放到中间
		int compareNum = array[right];

		while(i < right){
			if(array[i] <  compareNum){
				j++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			i++;
		}
		// 确定界位**
		j++;
		array[right] = array[j];
		array[j] = compareNum;
		return j;
	}




}
