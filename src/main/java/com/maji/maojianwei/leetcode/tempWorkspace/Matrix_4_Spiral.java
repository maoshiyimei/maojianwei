package com.maji.maojianwei.leetcode.tempWorkspace;


import java.util.Arrays;

/**
 * Class: ��������Ĺ���
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/15 , 15:24
 */
public class Matrix_4_Spiral {

    public static void main(String[] args){

        print(buildSpiralMatrix(3));
        print(buildSpiralMatrix(4));
        print(buildSpiralMatrix(5));

    }


    public static int[][] buildSpiralMatrix (int n) {
        int[][] matrix = new int[n][n];
        for( int i = 0 ; i < n ; i++){
            matrix[0][i] = i+1;
        }
        if( n == 1){
            return matrix;
        }
        int roundNum = n-1;
        int value = n+1;
        int row = 1;
        int col = n-1;
        String direction = "rightBottom";
        while(roundNum >= 1 ){
            if(direction.equals("rightBottom")){
                for( int i = 0 ; i < roundNum ; i ++) {
                    matrix[row++][col] = value++;
                }
                col--;
                row--;
                for( int i = 0 ; i < roundNum ;i++){
                    matrix[row][col--] = value++;
                }
                col++;
                row--;
                roundNum--;
                direction = "leftTop";
            }
            else{
                for( int i = 0 ; i < roundNum ; i ++) {
                    matrix[row--][col] = value++;
                }
                col++;
                row++;
                for( int i = 0 ; i < roundNum ;i++){
                    matrix[row][col++] = value++;
                }
                col--;
                row++;
                roundNum--;
                direction = "rightBottom";
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix){
        System.out.println("**********matrix "+ matrix.length + " ************");
        for( int i = 0 ;i < matrix.length; i++){
            for(int j = 0 ;j < matrix[0].length; j++){
                System.out.printf("%3d",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

