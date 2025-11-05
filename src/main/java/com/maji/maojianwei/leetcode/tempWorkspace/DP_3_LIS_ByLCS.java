package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

/**
 * Class: �����������-ʹ��lcs����ʵ�֣�ʱ�临�Ӷ�Ϊ O�� N^2 ) ;
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 20:11
 */
public class DP_3_LIS_ByLCS {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while(in.hasNextInt()){
            int temp = in.nextInt();
            list1.add(temp);
            list2.add(temp);
        }
        Collections.sort(list2);
        System.out.println( lcs(list1, list2) );
    }
    public static int lcs(List<Integer> list1, List<Integer> list2){
        int n = list1.size();
        int m = list2.size();
        int[][] c = new int[n+1][m+1];
        for( int i = 0 ;i <= n ;i ++){
            Arrays.fill(c[i], 0 );
        }
        for(int i = 1; i<= n ; i ++){
            for( int j = 1; j<= m ; j ++){
                if(list1.get(i-1) == list2.get(j - 1)){
                    c[i][j] = c[i-1][j-1] + 1;
                }
                else{
                    c[i][j] = Math.max( c[i-1][j] , c[i][j-1]);
                }
            }
        }
        return c[n][m];
    }
}
