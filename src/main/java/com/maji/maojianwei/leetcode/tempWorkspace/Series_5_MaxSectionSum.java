package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class:给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值
 * example:[ 6 ,2,1] -> 36
 * 81 87 47 59 81 18 25 40 56 0 -> 16685
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/6 , 20:26
 */
public class Series_5_MaxSectionSum {
    public static int[] arr = {81 ,87, 47, 59, 81 ,18 ,25 ,40 ,56 ,0};

    public static void main(String[] args){

        System.out.println( getMaxSectionResult(arr) );
    }

    /* 暴力遍历 O（n2)*/
    public static int getMaxSectionResult( int[] arr) {
        int n =arr.length;
        int max = 0;
        for(int i =0; i<n; i++){
            if(arr[i] == 0){
                continue;
            }
            int sum = arr[i] ;
            max =max > (sum*sum) ?max :(sum*sum);
            int min = arr[i];
            for(int j =i+1 ; j<n; j++){
                if(arr[j] == 0){
                    break;
                }
                sum += arr[j] ;
                min = min>arr[j]?arr[j]:min;
                int temp = sum*min;
                max = max > temp? max : temp ;
            }
        }

        return max;
    }
    /* 利用栈 类似于最大矩形题目 */
    public static int getMaxSectionResultByStack(int[] arr){

       return 0;
    }
//    n=int(raw_input())
//    arr=[int(x) for x in raw_input()[:-1].split(' ')]
//
//            arr.append(-1)
//    i=0
//    stack_pop_before=[]
//    stack=[]
//    ans=0
//            while i<=n:
//    num=arr[i]
//    pop_sum=0
//    pop_before=0
//            while stack and num<stack[-1]:
//    pop_num=stack.pop()
//    pop_sum+=pop_num
//    pop_before+=stack_pop_before.pop()
//    ans=max(ans,(pop_before+pop_sum)*pop_num)
//            stack_pop_before.append(pop_before+pop_sum)
//            stack.append(num)
//    i+=1
//    print ans
}
