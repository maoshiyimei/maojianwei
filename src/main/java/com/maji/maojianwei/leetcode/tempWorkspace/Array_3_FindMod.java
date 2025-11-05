package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:�ҳ����������еĳ���һ�������
 * ˼·�� �����Ƚϣ���ͬɾ������ͬ�ۼƣ�����ʵ��ʱ����һ��count��ͳ�Ƶ�ǰ��������ֵ������ͬ��������ͬ�ۼӡ��������ֵ���ǽ����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/17 , 19:40
 */
public class Array_3_FindMod {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 2, 2, 1, 1, 1, 2, 1, 1, 1, 9 };
        int count = 0 ;
        int result = array[0];
        for( int num : array){
            if( count == 0 ){
                result = num ;
            }
            if( result == num ){
                count ++ ;
            }
            else{
                count--;
            }
        }
        System.out.println( result );
    }

}
