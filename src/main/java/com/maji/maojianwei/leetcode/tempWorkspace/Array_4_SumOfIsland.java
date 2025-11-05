package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 *4 , 5
 * 11110
 * 11010
 * 11000
 * 00000
 */

public class Array_4_SumOfIsland {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[n][m];
        for(int i = 0 ;i < n ; i++) {
            for( int j = 0; j< m ;j++ ) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(getNumOfIsland(matrix));
    }
    public static int getNumOfIsland(int[][] matrix) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for( int i = 0 ; i < n ; i ++ ) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1) {
                    count++;
                    extendIsland(matrix, i , j );
                }
            }
        }
        return count;
    }
    public static void extendIsland(int[][] matrix, int row , int col){
        matrix[row][col] = 0;
        if( row-1 >= 0 && matrix[row-1][col] == 1){
            extendIsland(matrix, row-1, col);
        }
        if( row+1 < matrix.length && matrix[row+1][col] == 1){
            extendIsland(matrix, row+1, col);
        }
        if( col-1 >= 0 && matrix[row][col-1] == 1){
            extendIsland(matrix, row, col-1);
        }
        if( col+1 < matrix[0].length && matrix[row][col+1] == 1){
            extendIsland(matrix, row, col+1);
        }
    }
}
