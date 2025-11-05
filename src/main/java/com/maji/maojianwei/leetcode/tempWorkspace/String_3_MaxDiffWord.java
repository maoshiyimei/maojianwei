package com.maji.maojianwei.leetcode.tempWorkspace;



import java.util.*;

/**
 * Class: 字符串长度最大乘积
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/15 , 23:25
 */

/*  功能描述：   已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。
                如：
                words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
                words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
*/
public class String_3_MaxDiffWord {

    public static void main(String[] args) {
        System.out.println("************** Result *****************");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] words=new String[n];
        for(int i=0;i<n;i++){
            words[i] = "";
        }
        System.out.println("Words:");
        int count =0;
        for(String word : words){
            System.out.print(word + "    ");
            count++;
            if(count%20 == 0){
                System.out.println();
            }
        }

        Long start1 = System.currentTimeMillis();
        System.out.println( "\n result1:" + maxDiffWords(words));
        Long end1 = System.currentTimeMillis();
        System.out.println("nomal method time cost:"+ (end1-start1) +" ms");


    }
    /* 两层循环，一一比较，更新最大值  时间复杂度 n2*/
    public static int maxDiffWords(String[] words){
        if(words.length <=1) {
            return 0;
        }
        int result =0;
        int n = words.length;
        String word="";
        for(int i = 0; i < n; i++){
            word= words[i];
            char[] arr = word.toCharArray();
            Set<Character> letters = new HashSet<Character>();
            for(char letter : arr){
                letters.add(letter);
            }
            String compareWord="";
            for(int j =i+1; j < n; j++){
                compareWord=words[j];
                int len =compareWord.length();
                int k=0;
                for(; k<len ;k++){
                    Character c = compareWord.charAt(k);
                    if(letters.contains(c)){
                        break;
                    }
                }
                if(k==len){
                    int temp = word.length()*len;
                    result=(temp>result?temp:result);
                }
            }
        }
        return result;
    }


}
