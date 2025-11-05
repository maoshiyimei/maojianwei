package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * [1,2,3,4]
 * [1,3,2,4]
 */
public class ReorderArray {

    /**
     * 借助链表：空间复杂度较高
     */
    public int[] reOrderArray (int[] array) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i = 0 ; i< array.length ;i++){
            if(array[i]%2 == 0)
                even.add(array[i]);
            else
                odd.add(array[i]);
        }
        int i = 0;
        int j = 0;
        while(j < odd.size()){
            array[i++] = odd.get(j++);
        }
        j = 0;
        while(j < even.size()){
            array[i++] = even.get(j++);
        }
        return array;
    }

    /**
     * 方法2 ： 借助冒泡排序, 遇到 偶数 + 奇数的组合就交换, 空间效率有所提升，时间上则最差可以达到N^2
     */
    public int[] reOrderArray2 (int[] array){

        boolean flag = false;
        while(!flag){
            flag = true;
            for(int i = 1 ; i< array.length; i++){
                if(array[i-1]%2 == 0 && array[i]%2 == 1){
                    int tmp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = tmp;
                    flag = false;
                }
            }
        }
        return array;
    }

}
