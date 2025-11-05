package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: n�����⣬ʹ�û��ݷ���������ģʽ��n����������������Ϊ������ x[n]��ÿһ��Ԫ�� x[i] ��ʾ���з��ڵڼ����ϣ�
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 13:26
 */
public class BackTrack_4_N_Queen {
    public static int  n = 4;
    public static int[] x = new int[n];     /* ��ռ� */

    public static void main(String[] args){
        nQueen(0);
    }
    public static void nQueen(int i ){
        if( i == n ){
            print();   /* ���������ɴ�ӡ */
        }
        else{
            for(int j = 0 ;j<n; j++){
                if( judgePosition(i, j)){/* Լ������ */
                    x[i] = j;
                    nQueen(i+1);
                }
            }
        }
    }
    public static boolean judgePosition(int row , int col){
        for(int i = 0 ; i < row ; i ++ ){
            if(x[i] == col || Math.abs(x[i] - col) == Math.abs(i - row ) ){
                return false;
            }
        }
        return true;
    }
    public static void print(){
        for(int i = 0 ;i < n ; i ++ ){
            for(int  j = 0 ;j < n ;j ++){
                if(x[i] == j){
                    System.out.print("Q"+" ");
                }
                else{
                    System.out.print("-"+" ");
                }
            }
            System.out.println();
        }
        System.out.println("*********************************************");
    }

}
