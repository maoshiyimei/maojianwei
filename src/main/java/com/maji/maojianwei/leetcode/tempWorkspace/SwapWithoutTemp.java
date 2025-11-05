package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/29 , 21:57
 */
public class SwapWithoutTemp {
    public static void main(String[] args){
        int a = 1;
        int b = 3;
        System.out.println( "before swap :  a = "+ a +" ,b = "+ b );
        a = a + b ;
        b = a - b ;
        a = a - b ;
        System.out.println( "after swap :  a = "+ a +" ,b = "+ b );
    }
}
