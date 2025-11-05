package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: �ж�һ�����Ƿ��� 2 ����
 * λ���㣬 n-1 & n =0 ��Ϊ��������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 14:14
 */
public class Bit_3_JudgePowerOf2 {
    public static void main(String[] args){
        for( int i = 0 ; i < 65; i++){
            System.out.println( i + " : " + judgePowerOf2(i));
        }
    }
    public static boolean judgePowerOf2(int n ){
        if( n <=0){
            return false;
        }
        else{
           return (n&(n-1)) == 0 ;
        }
    }
}
