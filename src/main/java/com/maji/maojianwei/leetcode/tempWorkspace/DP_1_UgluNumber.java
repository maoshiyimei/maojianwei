package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: �ҳ��� n ����������������ֻ���������� 2, 3, 5 ����������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 15:41
 */
public class DP_1_UgluNumber {

    public static void main(String[] args){
        int[] data = printUglyNumber(20);
        for( int i = 1 ;i <= 20; i++){
            System.out.println( " the " + i + " td: " + data[i]);
        }
    }

    public static int[] printUglyNumber(int n ){
        if( n <= 0 ){
            System.out.println(" bad input");
            return null;
        }
        int[] number = new int[n+1];
        number[1] = 1;
        int i =2;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        while( i <= n ){
            int min = Math.min( number[index2]*2, number[index3] *3);
            min = Math.min(min, number[index5]*5 );
            if( min == number[index2] * 2 ){
                index2++;
            }
            if( min == number[index3] * 3 ){
                index3++;
            }
            if( min == number[index5] * 5 ){
                index5++;
            }
            number[i] = min;
            i++;
        }
        return number;
    }
}
