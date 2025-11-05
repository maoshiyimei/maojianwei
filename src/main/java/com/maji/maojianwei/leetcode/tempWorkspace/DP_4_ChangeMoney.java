package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;

/**
 * Class:/*һ����1��5��10��20��50��100��ֵ�Ļ��ң�nԪ�ж�������Ϸ�ʽ����
 * ˼·�� �����ṹ change[i][j] ��ʾ��������ֵ j ,ʹ�� i����ֵ�ķ�ʽ��Ŀ��
 * ����������̣� ���j < ��ֵ�� change[i][j]  = change[i-1][j]
 *�����ֵ�պõ���  j change[i][j]  = change[i-1][j]  + 1 ;
 * ���� change[i][j]  = change[i-1][j] + change[i][j- ��ֵ ]
 *
 * change[i][j - coins[i]  ��ʾ ������һ�Ÿ���ֵ����Ŀ ��ǰ�߱�ʾ��0 ����ֵ����Ŀ�� �����ǲ������ظ��ģ�

 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 18:28
 */
public class DP_4_ChangeMoney {

    public static void main(String[] args){
        int[] coins = {1,5,10,20,50,100};
        int n = 28; // Ǯ��
        long changeWays = calculateChangeWays(n, coins);
        System.out.println("all change ways : " + changeWays );

    }

    public static long calculateChangeWays( int n , int[] coins ){
        int m = coins.length;
        long[][] change = new long[m][n+1];
        Arrays.fill( change[0], 1); // ��ֵΪ 1 �� ����������ֵ����ֻ��һ�ֶһ���ʽ��
        for( int i = 1 ; i < m ; i ++ ){
            for( int j = 1 ; j <= n ; j ++ ){
                if( j < coins[i] ){
                    change[i][j] = change[i-1][j];
                }
                else if( j == coins[i] ){
                    change[i][j] = change[i-1][j] + 1 ;
                }
                else {
                    change[i][j] = change[i-1][j] + change[i][j - coins[i] ]; // û�õ�coins[i] ���õ� coins[i]�� �Ӻ�
                }
            }
        }
        print(change);
        return change[m-1][n];
    }


    public static void print(long[][] array){
        for( int i = 0 ; i < array[0].length; i ++){
            System.out.printf("%6d", i);
        }
        System.out.println();
        for(int i = 0 ; i < array.length; i ++){
            for(int j = 0 ; j< array[0].length; j++){
                System.out.printf("%6d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
