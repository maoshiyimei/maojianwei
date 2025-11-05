package com.maji.maojianwei.leetcode.tempWorkspace;



import java.util.ArrayList;
import java.util.List;

/**
 * Class: ����һ�����������������ӷֽ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/10 , 22:18
 */
public class Number_2_Decompose {
    public static void main(String[] args){
        for(int i = 2 ; i < 50; i ++){
            List<Integer> list = getPrimerList(  i );
            if( list.size() == 0){
                System.out.println( i + " : " + i);
            }
            else{
                System.out.print(i + " : ");
                for( int x : list ){
                    System.out.print( x + " ");
                }
                System.out.println();
            }
        }
    }
    /* ���ε�����������ʱ�临�Ӷ�Ϊ n/2 */
    public static List<Integer> getPrimerList( int n ){
        List<Integer> list = new ArrayList<>();
        int k = n/2;
        for( int i = 2 ; i <=  k  ; i++ ){
            while ( n % i == 0 ){
                list.add(i);
                n /= i;
            }
        }
        return list;
    }
}
