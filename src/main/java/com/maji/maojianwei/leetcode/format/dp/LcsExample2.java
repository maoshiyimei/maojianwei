package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * Class:两个字符串， 如何操作（删除）最少使得两个字符串相等，
 * 思路，先找LCS,这些字符可以不用动，其它不同的字符可以删除掉，
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 15:20
 */
public class LcsExample2 {
    public static void main(String[] args){
        String s1 = "cmagjir";
        String s2 ="maddejri"; // lcs = maji
        int length = lcs(s1, s2);
        System.out.println(" s1: " + s1);
        System.out.println(" s2: " + s2);
        System.out.println(" ops: " + (s1.length() + s2.length() - length*2 ) ) ;
    }
    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n+1][m+1];
        for(int i = 0 ;i <= n ; i ++){
            Arrays.fill( c[i], 0);
        }
        for(int i = 1; i<= n ;i++){
            for(int j = 1; j <= m ; j++){
                if( s1.charAt(i-1) == s2.charAt(j-1) ){
                    c[i][j] = c[i-1][j-1] + 1;
                }
                else{
                    c[i][j] = Math.max( c[i-1][j],  c[i][j-1] );
                }
            }
        }
        return c[n][m];
    }
}
