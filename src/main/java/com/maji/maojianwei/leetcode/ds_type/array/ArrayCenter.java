package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * Class:?	数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。
 * 如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 17:06
 */
public class ArrayCenter {
    public static int findArrayCenter(int[] array){
        if(array == null){
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0 ; i< array.length; i++){
            rightSum += array[i];
        }

        for(int i = 0 ;i < array.length; i++){
            rightSum -= array[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }
}
