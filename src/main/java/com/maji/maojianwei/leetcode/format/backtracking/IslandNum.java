package com.maji.maojianwei.leetcode.format.backtracking;


import com.maji.maojianwei.leetcode.utils.MatrixUtil;

/**
 * 200
 * desc: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 */
public class IslandNum {

    /**
     * dfs
     * @param area
     * @return
     */
    public static int getIslandNum(int[][] area){
        int count = 0;
        for(int i = 0 ;i< area.length; i++){
            for(int j = 0; j< area[0].length; j++){
                if(area[i][j] == 1){
                    System.out.println(i + " "+ j);
                    count++;
                    dfs(area, i, j);
                    System.out.println("---------------------------");
                    MatrixUtil.print(area);
                }

            }
        }
        return count;
    }

    public static void dfs(int[][] area, int row, int col){

        area[row][col] = 0;

        if(row - 1 >= 0 && area[row-1][col] == 1){
            dfs(area, row-1, col);
        }
        if(row +1 < area.length && area[row+1][col] == 1){
            dfs(area, row+1, col);
        }
        if(col-1 >= 0 && area[row][col-1] == 1){
            dfs(area, row, col-1);
        }
        if(col+1 < area[0].length && area[row][col+1] == 1){
            dfs(area, row, col+1);
        }
    }

}
