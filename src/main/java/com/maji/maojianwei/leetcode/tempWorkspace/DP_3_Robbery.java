package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:����������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ��������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 13:46
 */
public class DP_3_Robbery {

    public static void main(String[] args){
        int[] shop = {1,2,3,4,3,23,5,6,3,4,78,35};
        System.out.println( robMost(shop) );
    }

    /*������ĵݹ�ṹ: dp[i] = max{ dp[i-1] , dp[i-2] + shop[i] }*/
    /* ����Ŀռ���ʵ���Բ���n ֻ���������������޸ļ��� */

    public static int robMost(int[] shop){
        if( shop == null ){
            return 0;
        }
        else if( shop.length == 1){
            return shop[0];
        }
        int n = shop.length;
        int[] dp = new int[n];
        dp[0] = shop[0];
        dp[1] = Math.max(shop[0], shop[1]);
        for( int i = 2 ; i< n ; i++){
            dp[i] = Math.max( dp[i-1], dp[i-2]+ shop[i]);
        }
        return dp[n-1];

    }
}
