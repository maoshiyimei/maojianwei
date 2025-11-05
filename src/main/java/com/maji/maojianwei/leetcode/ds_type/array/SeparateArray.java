package com.maji.maojianwei.leetcode.ds_type.array;


/**
 * 数组， 负数放在左边， 正数放在右边
 */
public class SeparateArray {

    /**
     * 借助冒泡排序的思想，保证稳定性
     * @param array
     */
    public static void separate(int[] array){
        boolean flag = false;
        while(!flag){
            flag = true;
            for( int i = 1; i < array.length; i++){
                if(array[i] < 0 && array[i-1] >= 0){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    flag= false;
                }
            }
        }
    }

    /**
     * 加一个条件： 如果是 0 正数 的情况也需要交换， 这样可以保证负数 0 正数的最终结果。
     * @param array
     */
    public static void separate2(int[] array){
        boolean flag = false;
        while(!flag){
            flag = true;
            for( int i = 1; i < array.length; i++){
                if(array[i] < 0 && array[i-1] >= 0 || array[i] == 0 && array[i-1] >0){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    flag= false;
                }
            }
        }
    }
}
