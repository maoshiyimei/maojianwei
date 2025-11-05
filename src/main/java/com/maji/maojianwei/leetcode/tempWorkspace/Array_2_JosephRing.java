package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Լɪ��
 * ѭ������Ļ�ʱ�临�ӶȱȽϴ�O(NM) ) ;
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/16 , 23:12
 */
public class Array_2_JosephRing {

    public static void main(String[] args){
        int n = 8 ;
        josephRing1(n,3);
        josephRing2(n,3);
    }
    /* i ��ʾ����һλ��ʼ������Ĭ���ϴ�Ϊ0 */

    public static void josephRing1(int n ,int m ){

        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i<= n ; i++){
            list.add(i);
        }
        int i = 0;
        while(!list.isEmpty()){
            i = (i+m-1)%list.size();
            System.out.println(list.get(i));
            list.remove(i);
        }
    }

    public static void josephRing2(int n ,int m ){

        int[] array = new int[n];
        for(int i = 1 ; i<= n ; i++){
            array[i-1] = i;
        }
       int count = 0 ;
       for( int i= 0 ; i < n ; i++){
           count = (count + m-1 )%(n-i);
           System.out.println( array[count]);
       }
    }
}
