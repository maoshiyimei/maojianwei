package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: 比较两个包含推退格#的字符串是否相等
 * example: ad#c  与 ab#c 是相等的；
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/31 , 20:44
 */
public class Stack_2_CompareTwoString {
    public static String S = "ad#c";
    public static String T = "ab#c";
    public static void main(String[] args){
        System.out.println( compareTwoStringByString(S , T ) );
    }

    public static boolean compareTwoStringByString(String S , String T ) {
        return removeBackplaceByString( S ).equals( removeBackplaceByString( T ) );
    }

    public static String removeBackplaceByString(String s) {
        int n = s.length();
        char[] letters = s.toCharArray();
        int j = 0;
        for(int  i =0 ; i < n ; i++, j++ ){
            letters[j] = letters[i];
            if(letters[j] == '#'){
                if( j == 0){
                    j--;
                }
                else{
                    j-=2;
                }
            }
        }
        return new String(letters, 0 , j );
    }





}
