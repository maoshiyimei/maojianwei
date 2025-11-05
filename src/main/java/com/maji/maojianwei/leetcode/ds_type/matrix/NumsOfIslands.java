package com.maji.maojianwei.leetcode.ds_type.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumsOfIslands {
    /**
     * BFS:
     * 如果不标记成2，而是直接改成0 会有重复计算， 因为一个位置可以是两个边界的公共，

     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '2';
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for( int k = 0; k<size; k++){
                            int[] loc = queue.poll();
                            grid[loc[0]][loc[1]] = '0';
                            if (loc[0]-1 >= 0 && grid[loc[0]-1][loc[1]] == '1'){
                                grid[loc[0]-1][loc[1]] = '2';
                                queue.offer(new int[]{loc[0]-1, loc[1]});
                            }
                            if (loc[0]+1 < n && grid[loc[0]+1][loc[1]] == '1'){
                                grid[loc[0]+1][loc[1]] = '2';
                                queue.offer(new int[]{loc[0]+1, loc[1]});
                            }
                            if (loc[1]-1 >= 0 && grid[loc[0]][loc[1]-1] == '1'){
                                grid[loc[0]][loc[1]-1] = '2';
                                queue.offer(new int[]{loc[0], loc[1]-1});
                            }
                            if (loc[1]+1 < m && grid[loc[0]][loc[1]+1] == '1'){
                                grid[loc[0]][loc[1]+1] = '2';
                                queue.offer(new int[]{loc[0], loc[1]+1});
                            }
                        }
                    }
                }
            }
        }
        return count;

    }


    /**
     * dfs
     * 不需要考虑重复的问题， 因为不会漏，也不会重复
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int n = grid.length;
        if (n==0) {
            return 0;
        }
        int m = grid[0].length;

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j=0; j < m ; j++){
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;
        //递归出口
        if(row < 0 || col < 0 || row >= n || col >= m){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }

        //修改值避免重复遍历导致栈溢出
        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

}
