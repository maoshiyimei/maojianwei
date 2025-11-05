package com.maji.maojianwei.leetcode.format.dp;

import java.util.Arrays;

/**
 * Class:如果一个字符串S是由两个字符串T连接而成,即S = T + T,
 *  * 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
 * 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,
 * 让剩下的字符串是一个平方串。
 * 换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 * 思路是：随意切分，两个字串的LCS的个数最大
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 15:07
 */
public class LcsExample {
    public static void main(String[] args) {
        String s = "dafcdgqdefragchdegtof";// acdefacdef
        int result = 0;
        int n = s.length();
        for(int i =1;i<n;i++) {
            int temp = lcs(s.substring(0,i),s.substring(i,n));
            if(result < temp) {
                result = temp;
            }
        }
        System.out.println(result*2);
    }
    public static int lcs(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n+1][m+1];
        for(int i =1; i <= n; i++) {
            for(int j =1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1]+1;
                }
                else if( c[i-1][j] > c[i][j-1] ) {
                    c[i][j] = c[i-1][j];
                }
                else {
                    c[i][j] = c[i][j-1];
                }
            }
        }
        return c[n][m];
    }

}

