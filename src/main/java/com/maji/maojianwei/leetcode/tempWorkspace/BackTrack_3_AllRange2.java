package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/16 , 10:35
 */
public class BackTrack_3_AllRange2 {
    public static void main(String[] args){
        String s = "alin";
        String[] range = permutation(s);
        for( int i = 0 ; i < range.length; i++){
            System.out.println(range[i]);
        }
    }
    public static String[] permutation(String str){
        List<String> list = new ArrayList<>();
        backtracking(str.toCharArray(), 0 , list);
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
    public static void backtracking(char[] letters, int k , List<String> list){
        if( k == letters.length){
            list.add( new String(letters));
        }
        else{
            for( int i = k ; i < letters.length ; i++){
                char temp = letters[i];
                letters[i] = letters[k];
                letters[k] = temp;

                backtracking(letters, k+1, list);
                temp = letters[i];
                letters[i] = letters[k];
                letters[k] = temp;
            }
        }
    }



}
