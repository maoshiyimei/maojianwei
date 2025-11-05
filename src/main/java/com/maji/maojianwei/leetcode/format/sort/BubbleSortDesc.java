package com.maji.maojianwei.leetcode.format.sort;//属于交换排序


/**
 * 降序的冒泡排序算法
 */

public class BubbleSortDesc {

	public static void BubbleSort(int[] array) {
		bubbleSort(array);
	}

	/**
	 * flag 用户及时停止， 避免无必要的比较 时间复杂度为 o(n2)
	 */
	public static void bubbleSort(int[] array) {
		boolean flag = false;

		// 外层循环应该是从最右边依次向左缩小，每一次都是将最后固定
		for(int i = array.length-1; i > 0 && !flag ; i--){
			flag = true;
			for(int j = 0 ; j< i; j++){
				if(array[j] < array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
		}
	}

}
