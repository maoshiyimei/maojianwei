package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 21:34
 */
public class Pacakge_4_ExamMaxScores {
    private static int EXAM_TIME = 120;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] array = new int[n][4];
        for(int i = 0 ;i < n ; i++){
            for(int j = 0 ;j < 4 ;j++) {
                array[i][j] = in.nextInt();
            }
        }
        //System.out.println( getMaxExamScore(array) );
    }
    public static int getExamTime(int[][] array){
        return 0;

    }
    public static int getMaxScoreByValueRate(int[][] array){
        int n = array.length;
        double[][] valueRate = new double[n][2];
        for(int i = 0; i< n ;i++ ){
            valueRate[i][0] = array[i][1]*1.0/array[n][0];
            valueRate[i][1] = array[i][3]*1.0/array[n][2];
        }
        int time = 0;
        while(time <= EXAM_TIME){

        }
        return 0;

    }
}
