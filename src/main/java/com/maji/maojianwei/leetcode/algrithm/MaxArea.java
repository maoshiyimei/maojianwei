package com.maji.maojianwei.leetcode.algrithm;
/*给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。 
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。 
 *
 * 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 * 暴力方法O（N2）；*/
import java.util.*;
public class MaxArea{
	private static int[] areas; 
	private static int min=0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        areas = new int[n];
        for(int i =0;i<n;i++){
            array[i] = in.nextInt();
            areas[i] =0;
        }
        for(int i =0;i<n;i++) {
        	solution(array,i);
        }
        for(int i =0;i<n;i++)
        	System.out.println(areas[i]);
    }
    public static void solution(int[] array,int k) {
    	int p = array[k];
    	if(p<=array[min]) {
    		min = k;
    		areas[k] =(k+1)*p;
    	}else {
    		int temp1=(k+1)*min;
    		int left = k-1;
    		if(left>min && array[left]>p) {
    			left--;
    		}
    		int temp2=areas[left]+array[left]*(k-left);
    		areas[k] =Math.max(temp1, temp2);
    	}
    	
    }
}