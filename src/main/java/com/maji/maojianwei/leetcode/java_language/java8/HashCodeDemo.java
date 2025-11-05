package com.maji.maojianwei.leetcode.java_language.java8;

public class HashCodeDemo {

    public static void main(String[] args){
        String s = "ab";
        System.out.println(s.hashCode());

        int hash = 0;
        for(int i = 0; i< s.length(); i++){
            hash = hash* 31 + s.charAt(i);
            System.out.println(hash);
        }
    }
}
