package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;

/**
 * Class:�ַ����г��ִ��������ַ�������ж����ͬ��һ��Ϊ׼
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/22 , 21:13
 */
public class String_2_ModLetter {
    public static void main(String[] args){
        String s = "sdsadfgktuadaddsaaa";
        System.out.println( getMostLetter( s ));
    }
    public static char getMostLetter( String s){
        char[] letters = s.toCharArray();
        Arrays.sort(letters);
        int n = letters.length;
        int max = 1 ;
        char temp = letters[0] ;
        int count = 0 ;
        for(int i = 1 ;i < n ;i++){
            if( letters[i] == letters[i-1] ){
                count ++;
            }
            if(letters[i] != letters[i-1] || i == n-1){
                if( count > max ){
                    max = count;
                    temp = letters[i-1];
                }
                count = 1;
            }
        }
        return temp;
    }

}
