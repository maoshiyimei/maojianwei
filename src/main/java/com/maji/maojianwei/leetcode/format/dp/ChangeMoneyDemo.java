package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/11 , 10:44
 */
public class ChangeMoneyDemo {
    public static void main(String[] args){
        int[] coins = {1,5,10};
        int n = 10; // Ç®Êý
        long changeWays = calculateChangeWays(n, coins);
        System.out.println("all change ways : " + changeWays );

    }

    public static long calculateChangeWays( int n , int[] coins ){
        int m = coins.length;
        long[][] change = new long[m][n+1];
        Arrays.fill( change[0], 1);
        for( int i = 1 ; i < m ; i++){
            for( int j = 0;j <= n ; j++ ){
                if( j < coins[i]){
                    change[i][j] = change[i-1][j];
                }
                else if( j == coins[i ] ){
                    change[i][j] = change[i-1][j] + 1;
                }
                else{
                    change[i][j] = change[i-1][j] + change[i][j- coins[i]];
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
