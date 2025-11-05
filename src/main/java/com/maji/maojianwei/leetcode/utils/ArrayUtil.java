package com.maji.maojianwei.leetcode.utils;

import java.util.List;

/**
 * @author weitong
 * @date 2022/02-13 11:51 上午
 */
public class ArrayUtil {
    /**
     * 随机生成指定大小的数组：范围默认 0 - 100
     * @param size
     * @return
     */
    public static int[] generateRandomArray(int size){
        if(size <= 0){
            return new int[0];
        }
        int[] array = new int[size];
        for(int i =0; i<size; i++) {
            array[i] =(int)( Math.random()*100);
        }
        return array;
    }

    /**
     * 随机生成指定大小的数组：范围 0 - range
     * @param size
     * @param range
     * @return
     */
    public static int[] generateRandomArrayByRange(int size, int range){
        if(size <= 0){
            return new int[0];
        }
        if(range <= 0){
            range = 100;
        }
        int[] array = new int[size];
        for(int i =0; i<size; i++) {
            array[i] =(int)( Math.random()*range);
        }
        return array;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array){
        for(int i =0; i<array.length;i++) {
            System.out.printf("%3d",array[i]);
            if(i%50 ==49) {
                System.out.println();
            }
        }
        System.out.println();
    }
    /**
     * 打印数组
     * @param array
     */
    public static void printArray(List<Integer> array){
        for(int i =0; i<array.size();i++) {
            System.out.printf("%3d",array.get(i));
            if(i%50 ==49) {
                System.out.println();
            }
        }
        System.out.println();
    }



}
