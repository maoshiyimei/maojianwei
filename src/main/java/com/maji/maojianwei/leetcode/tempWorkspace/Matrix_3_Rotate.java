package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/31 , 20:37
 */
public class Matrix_3_Rotate {
    public static int[][] array = {
            {1, 2, 3, 4, 5, 6},
            {7, 8, 9, 10, 11, 12},
            {13, 14, 15, 16, 17, 18},
            {19, 20, 21, 22, 23, 24}
    };
    public static void main(String[] args){
        int n = 12;
        n %= 4;
        print();

        for( int i = 1; i<= n; i++){
            rotate();
            print();
        }


    }
    public static void rotate(){
        int n = array.length;
        int m = array[0].length;
        int[][] newArray = new int[m][n];
        for( int i = 0 ; i < n ;i ++){
            for(int j = 0 ; j< m ; j++){
                newArray[j][n-1-i]  = array[i][j];
            }
        }
        array = newArray;
    }

    public static void print(){
        int n = array.length;
        int m = array[0].length;
        System.out.println("******** Rotate **********");
        for(int i = 0 ;i< n ;i ++){
            for( int j = 0 ;j< m;j++){
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println("***************************");
    }
}
