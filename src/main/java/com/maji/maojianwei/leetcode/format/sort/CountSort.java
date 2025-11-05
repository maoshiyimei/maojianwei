package com.maji.maojianwei.leetcode.format.sort;

/**
 * Class: 计数排序
 * 数字在一定范围内；
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:47
 */
public class CountSort {
    //数值范围 0 ～ N-1
    public static int N = 100;

    public static void countSort(int[] array){
        int[] count = new int[N];
        // 计数
        for(int i = 0 ; i< array.length; i++){
            count[array[i]] ++;
        }
        //累加
        for(int i = 1 ; i< count.length; i++){
            count[i] += count[i-1];
        }
        // 排序
        int[] res = new int[array.length];
        for(int i = 0; i < array.length; i++){
            // 注意个数和序号的问题, 个数不是从0开始的
            res[count[array[i]]-1] = array[i];
            count[array[i]]--;
        }
        // 赋值
        for(int i = 0; i< array.length; i++){
            array[i] = res[i];
        }

    }



}
