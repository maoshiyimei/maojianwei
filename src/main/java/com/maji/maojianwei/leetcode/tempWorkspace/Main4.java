package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;
public class Main4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] data = new long[n][2];
        for(int i = 0 ; i< n ; i++){
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
        }
        for( int  i = 0 ; i < n ; i ++){
            long x = data[i][0];
            long k = data[i][1];
            int level = getLevel(x);
            if( level <= k || k < 1 ){
                System.out.println(-1);
            }
            else{
                int acc = 0;
                for( int j  = level; j > k ; j--){
                    acc++;
                }
                System.out.println(x/(int)(Math.pow(2,acc)));
            }
        }
    }
    public static int getLevel(long x ){
        if( x == 1){
            return 1;
        }
        int count = 0;
        int acc = 1;
        while( acc < x){
            acc *= 2;
            count++;
        }
        return count;
    }

}
