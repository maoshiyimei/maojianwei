package com.maji.maojianwei.leetcode.tempWorkspace;



/**
 * Class: �̵��������ģ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 13:56
 */
public class DP_3_Robbery_Circle {
    public static void main(String[] args){
        int[] shop = {1,2,3,4,3,23,5,6,3,4,78,35};
        int most = Math.max( robMost( shop, 0,shop.length -2), robMost( shop, 1, shop.length-1) );
        System.out.println( most);
    }
    public static int robMost(int[] shop, int start, int end ){
        if( start == end){
            return shop[start];
        }
        int take_this = shop[start];
        int not_take = 0;
        for( int i = start+1; i <= end; i++){
            int temp = take_this;
            take_this = Math.max( take_this, not_take + shop[i] );
            not_take = temp;
        }
        return take_this;
    }

}
