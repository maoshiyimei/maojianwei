package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

/**
 * Class: 二维01矩阵，1标识陆地，0标识海洋，连续的陆地构成岛屿，求岛屿的数目；
 * 4 4
 * 0010
 * 1100
 * 0101
 * 0101
 * -> 3
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/26 , 22:38
 */
public class Matrix_4_SumOfIsland {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[n][m];
        for(int i = 0 ;i < n ; i++) {
            String row = in.nextLine();
            for( int j = 0; j< m ;j++ ) {
                matrix[i][j] = Integer.valueOf( row.charAt(j)-48);
            }
        }
        System.out.println(getNumOfIsland(matrix));
    }
    public static int getNumOfIsland(int[][] matrix) {
        int num = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<ArrayList<Integer>> islandElement = new LinkedList<>();
        for( int i = 0 ; i< n ; i++ ){
            for(int j = 0 ; j< m ;j++ ) {
                if(matrix[i][j] == 1){
                    num++;
                    matrix[i][j] = 0;
                    islandElement.clear();
                    islandElement.offer( new ArrayList<Integer>(Arrays.asList(i,j)) );
                    while( !islandElement.isEmpty()){
                        ArrayList<Integer> curCoord = islandElement.poll();
                        int tempI = curCoord.get(0);
                        int tempJ = curCoord.get(1);
                        if(tempI-1>=0 && matrix[tempI-1][tempJ]==1){
                            matrix[tempI-1][tempJ]=0;
                            islandElement.offer( new ArrayList<Integer>(Arrays.asList(tempI-1,tempJ)) );
                        }
                        if(tempI+1 < n  && matrix[tempI+1][tempJ]==1){
                            matrix[tempI+1][tempJ]=0;
                            islandElement.offer( new ArrayList<Integer>(Arrays.asList(tempI+1,tempJ)) );
                        }
                        if(tempJ-1 >= 0  && matrix[tempI][tempJ -1]==1){
                            matrix[tempI][tempJ-1]=0;
                            islandElement.offer( new ArrayList<Integer>(Arrays.asList(tempI,tempJ-1)) );
                        }
                        if(tempJ+1 < m  && matrix[tempI][tempJ + 1]==1){
                            matrix[tempI][tempJ+1]=0;
                            islandElement.offer( new ArrayList<Integer>(Arrays.asList(tempI,tempJ+1)) );
                        }
                    }
                }
            }
        }
        return num;
    }

}
