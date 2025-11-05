package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中最小的k个数
 */
public class FindMinKnum {

    /**
     * 分治算法：
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k == 0 || k > input.length){
            return res;
        }
        int left = 0;
        int right = input.length-1;
        while(true){
            int p = partition(input, left, right);
            int num = p -left + 1;
            if(num == k){
                for(int i = left; i<= p; i++){
                    res.add(input[i]);
                }
                return res;
            }
            else if(num > k ){
                right = p-1;  // 不包括分界点
            }
            else{
                for(int i = left; i<= p; i++){
                    res.add(input[i]);
                }
                k -=  num;
                left = p+1;  //不包括分界点
            }
        }
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i  = left;
        int j = left -1;
        while(i < right){
            if(arr[i] < pivot){
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
        }
        j++;
        arr[right] = arr[j];
        arr[j] = pivot;
        return j;
    }


    public static int[] getKthMin(int[] array, int k){
        if(array.length < k){
            return null;
        }
        if(array.length == k){
            Arrays.sort(array);
            return array;
        }
        List<Integer> res = new ArrayList<>();
        getKthMinInRange(array, 0, array.length-1, k, res);
        int[] kMin = new int[res.size()];
        for(int i = 0; i< kMin.length; i++){
            kMin[i] = res.get(i);
        }
        Arrays.sort(kMin);
        return kMin;
    }

    public static void getKthMinInRange(int[] array, int left, int right, int k , List<Integer> res){
        if(left > right){
            return;
        }

        int p = partition(array, left, right);
        int num = p - left;
        if( num <= k){
            for( int i = left; i< p ;i++){
                res.add(array[i]);
            }
            if( num < k){
                getKthMinInRange(array, p, right, k-num, res);
            }
        } else if( num > k){
            getKthMinInRange(array, left, p-1, k, res);
        }
    }

}
