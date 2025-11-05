package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * ����һ���ַ���str��strȫ���������ַ���ɣ����str�е�ĳһ���������������ַ���ɵ��Ӵ�ֵ��1~26֮��
 * ��������Ӵ�����ת��Ϊһ����ĸ���涨��1��ת��Ϊ��A������2��ת��Ϊ��B��......"26"ת��Ϊ��Z��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/29 , 22:21
 */
public class String_3_ChangeNumberToLetter {
    public static void main(String[] args){
        String s = "0123412521";
        StringBuilder sb = new StringBuilder();
        changeNumberToLetter(s, 0, sb);
    }
    public static void changeNumberToLetter( String str , int k , StringBuilder destStr ){
        if( k == str.length() ){
            System.out.println( destStr.toString() );
        }
        else{
            if( str.charAt(k) == '0' ){
                destStr.append('0');
                changeNumberToLetter( str, k+1, destStr );
            }
            else{
                int num1 = Integer.parseInt( str.substring(k, k+1));
                int num2 =  k+1 < str.length() ? Integer.parseInt( str.substring(k, k+2)) : 99;
                destStr.append( (char)(64 + num1 ) );
                changeNumberToLetter(str, k+1, destStr );
                destStr.deleteCharAt(destStr.length() - 1);
                if( num2 < 27 ){
                    destStr.append( (char)(64 + num2 ) );
                    changeNumberToLetter(str, k+2, destStr);
                    destStr.deleteCharAt(destStr.length()-1);
                }
            }
        }
    }
}
