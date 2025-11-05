package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class:
 * example: dllloeeedddwwvvzzajkkkffffzzzrrrmvvvzzzgggl -> dlloeedwwvzzajkkfzzrmvvzggl
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/1 , 16:51
 */
public class String_3_ErrorCorrection {
    public static String sentence = "dlloeedwwvzzajkkfzzrmvvzggl";
    public static void main(String[] args){
        System.out.println(sentence);
        System.out.println("you answer : ");
        System.out.println(correctSpellingMistake(sentence));
        System.out.println("should be : ");
        System.out.println("dlloeedwwvzzajkkfzzrmvvzggl");
    }
    public static String correctSpellingMistake(String sentence){
        char[] letters = sentence.toCharArray();
        int n = letters.length;
        int j = 0;
        boolean hasDouble = false;
        for(int i = 0 ;i < n ;i++, j++){
            letters[j] = letters[i];
            if(j>0 && !hasDouble && letters[j] == letters[j-1]){
                hasDouble= true;
                continue;
            }
            if(hasDouble && letters[j] == letters[j-1]){
                j--;
                continue;
            }
            if(hasDouble && letters[j] != letters[j-1] && letters[j-1] == letters[j-2]){
                continue;
            }
            if(hasDouble && letters[j] != letters[j-1]){
                hasDouble= false;
                continue;
            }
            if(hasDouble && letters[j] == letters[j-1] && letters[j-1] != letters[j-2]){
                j--;
                hasDouble = false ;
                continue;
            }
        }
        return new String(letters, 0, j);
    }
}
