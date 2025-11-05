package com.maji.maojianwei.leetcode.ds_type.matrix;

/**
 * 695. 岛屿的最大面积
 * 中等
 * 1K
 * 相关企业
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class AreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        if (n==0) {
            return 0;
        }
        int m = grid[0].length;

        int area = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j=0; j < m ; j++){
                if (grid[i][j] == 1) {
                    int curArea = dfs(grid, i, j);
                    if(area < curArea) {
                        area = curArea;
                    }

                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        //递归出口
        if(row < 0 || col < 0 || row >= n || col >= m){
            return 0 ;
        }
        if(grid[row][col] == 0){
            return 0 ;
        }
        grid[row][col] = 0;
        return 1 +
                dfs(grid, row-1, col) +
                dfs(grid, row+1, col) +
                dfs(grid, row, col-1) +
                dfs(grid, row,col +1);

    }
}
