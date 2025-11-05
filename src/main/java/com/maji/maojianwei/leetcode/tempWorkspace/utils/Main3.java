package com.maji.maojianwei.leetcode.tempWorkspace.utils;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/24 , 0:47
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] rounds = new int[n];
        for(int i = 0 ;i < n;i++){
            rounds[i] = in.nextInt();
        }
        System.out.println( getMinGames(rounds, n ) );
    }
    public static int getMinGames(int[] rounds, int  n ) {
        int max = 0;
        int total = 0;
        for(int round : rounds){
            total += round;
            if( round > max){
                max  = round;
            }
        }
        int result = max ;
        while((result*n - total) < n ){
            result++;
        }
        return result;
    }
}
