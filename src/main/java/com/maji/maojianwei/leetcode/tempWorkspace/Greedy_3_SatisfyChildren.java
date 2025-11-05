package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;

/**
 * Class: n �����ɣ�ÿ����СΪsize[i],�ָ�m��С���ѣ� a[i] ΪС���ѵ�θ�ڣ��ٵ�
 * �ߴ���ڵ���θ�ڵ�С���ѱ����㣬������С�������㣻
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/9 , 14:55
 */
public class Greedy_3_SatisfyChildren {
    public static void main(String[] args){
        int[] size = {2,3,4,2,3,5,1,5,7,3};
        int[] appetite = {1,3,4,8,4,2,7,5,4,9};
        // 1-1, 2-2, 3-3, 4-4, 4-5, 4-5, 5-7,
        System.out.println( solution(size, appetite));
    }
    public static int solution(int[] size, int[] appetite){
        Arrays.sort(size);
        Arrays.sort(appetite);
        int n = appetite.length;
        int m  = size.length;
        int count = 0 ;
        int j = 0 ;
        for( int i = 0 ; i < m && j < n; i++){
            if( appetite[j] <= size[i]){
                count++;
                j++;
            }
        }
        return count;
    }

}
