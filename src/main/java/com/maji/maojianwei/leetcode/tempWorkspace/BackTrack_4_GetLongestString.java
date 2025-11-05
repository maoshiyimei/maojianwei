package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class:
 * ["a", "abc", "d", "de", "def"] - > 6
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 18:42
 */
public class BackTrack_4_GetLongestString {
    public static int maxL = 0 ;
    public static StringBuilder s = new StringBuilder();

    public static void main(String[] args){
        List<String> list = Arrays.asList( new String[]{"a", "abc", "d", "de", "def"} );
        getMaxString(list, 0);
        System.out.println(maxL);
    }
    public static int maxLength(List<String> arr) {
        getMaxString(arr, 0);
        return maxL;
    }
    /* ���ݷ�����ѡ��ÿһ���ִ�Ҫ�żӵ����У�Ҫô���ӣ�ע������stringbuilder d��delete ������ */
    public static void getMaxString(List<String> list, int k){
        int n = list.size();
        if( k == n){
            return;
        }
        else{

            if( !hasCommomChar(s.toString(), list.get(k)) ){
                s.append(list.get(k));
                if(s.toString().length() > maxL){
                    maxL = s.toString().length();
                }
                getMaxString(list,k+1);
                s.delete(s.length() - list.get(k).length(), s.length());
            }
            getMaxString(list , k+1);

        }
    }

    public static boolean hasCommomChar(String originString, String newString){
        if( originString == "" || originString == null ){
            return false;
        }
        if(originString.length() != originString.toLowerCase().chars().distinct().count()
                || newString.length() != newString.toLowerCase().chars().distinct().count() ){
            return true;
        }
        int n = newString.length();
        for(int i = 0 ;i < n ;i ++){
            if(originString.contains(String.valueOf(newString.charAt(i)) ) ){
                return true;
            }
        }
        return false;
    }
}


