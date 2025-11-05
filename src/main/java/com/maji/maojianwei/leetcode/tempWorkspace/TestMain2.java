package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

public class TestMain2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i< n ;i++){
            array[i] = in.nextInt();
        }
        System.out.println( solution(array, x ));

    }
    public static int solution(int[] array, int x ) {
        int n = array.length;
        int mod = getMod(array);
        int value = getValue(array);
        System.out.println(mod);
        System.out.println(value);

        for( int i =0 ;i< n ;i++){
            if(array[i] != value){
                int temp = array[i]&x;System.out.println(temp);
                if( temp == value ){
                    mod++;
                }
            }
        }
        return mod;
    }

    public static int getMod(int[] array){
        int n = array.length;
        List<Integer> list= new ArrayList<>();
        for(int i= 0 ; i < n ;i ++){
            list.add(array[i]);
        }
        Collections.sort(list);
        int mod = 0;
        int temp = 0;
        for(int i = 0 ;i< n; i++){
            if(i==0 || list.get(i) == list.get(i-1) ){
                temp++;
            }
            else{
                mod = temp> mod? temp: mod;
                temp =1;
            }
        }
        return mod;
    }
    public static int getValue(int[] array){
        int n = array.length;
        List<Integer> list= new ArrayList<>();
        for(int i= 0 ; i < n ;i ++){
            list.add(array[i]);
        }
        Collections.sort(list);
        int mod = 0;
        int temp = 0;
        int value = list.get(0);
        for(int i = 0 ;i< n; i++){
            if(i==0 || list.get(i) == list.get(i-1) ){
                temp++;
            }
            else{
               if(temp > mod){
                   mod = temp;
                   value = list.get(i-1);
               }
                temp =1;
            }
        }
        return value;
    }




}
