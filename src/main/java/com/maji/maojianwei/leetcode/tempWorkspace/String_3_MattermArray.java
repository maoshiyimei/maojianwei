package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class: ���ִ� S �̴� T�� ����a ��S�ĳ���һ����a[i]��ʾ��0 �� i ��S���ִ��к���T�ĸ�����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/24 , 1:00
 */
public class String_3_MattermArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s  = in.nextLine();
        String t  = in.nextLine();
        int[] result = getMattermArray(s,t);
        for(int num : result){
            System.out.print(num + " ");
        }

    }
    /* ע���ַ�����subString(�ڶ�������������)*/
    public static int[] getMattermArray(String s ,String t ){
        int n = s.length();
        int m = t.length();
        int[] result = new int[n];
        StringBuilder temp = new StringBuilder();
        result[0] = 0;
        for(int i =0 ;i < n; i++){
            temp.append(s.charAt(i));
            if(i-m+1>=0 && temp.toString().substring(i-m+1, i+1).equals(t)  ){

                if( i == 0 ){
                    result[0] =1;
                }
                else{
                    result[i] = result[i-1] +1;
                }
            }
            else{
                if( i == 0 ){
                    result[0] =0;
                }
                else{
                    result[i] = result[i-1];
                }
            }
        }
        return result;
    }
}
