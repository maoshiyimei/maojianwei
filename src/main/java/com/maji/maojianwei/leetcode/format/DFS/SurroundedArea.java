package com.maji.maojianwei.leetcode.format.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
 即边界以及和边界上的O相连的视为为被包围的
 * @Author maojianwei
 * @Date 2020/8/11 14:08
 **/
public class SurroundedArea {
    /* dfs , 先对四周的O找到所有的，并替换为S, 然后将剩余的O转为x,替换的转回O即可*/
    public void solve(char[][] board) {
        int n = board.length;
        if(n == 0) return;
        int m = board[0].length;
        for(int i = 0 ;i <n;i++){
            dfs(board, i, 0);
            dfs(board, i, m-1);
        }
        for(int i = 0; i< m ;i ++){
            dfs(board, 0, i);
            dfs(board, n-1, i);
        }
        for(int i = 0 ;i < n ;i++){
            for(int j = 0 ; j< m ;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    /* dfs 尽量避免重复代码 */
    public void dfs(char[][] board, int row ,int col){
        int n = board.length;
        int m = board[0].length;
        if(row>=0 && row < n && col >=0 && col< m){
            if(board[row][col] == 'O'){
                board[row][col] = 'S';
                dfs(board, row-1, col);
                dfs(board, row+1, col);
                dfs(board,  row, col-1);
                dfs(board,  row, col+1);
            }
        }
    }
    /* BFS， 思路类似 */
    public void solve2(char[][] board) {
        int n = board.length;
        if(n == 0) return;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ;i <n;i++){
            if(board[i][0] == 'O')
                queue.offer( new int[]{i, 0} );
            if(board[i][m-1] == 'O')
                queue.offer( new int[]{i, m-1});
        }
        for(int i = 0; i< m ;i ++){
            if(board[0][i] == 'O')
                queue.offer( new int[]{0, i} );
            if(board[n-1][i] == 'O')
                queue.offer( new int[]{n-1, i});
        }
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            board[pos[0]][pos[1]] = 'S';
            if(pos[0]-1 >=0 && board[pos[0]-1][pos[1]] == 'O')
                queue.offer(new int[]{pos[0]-1, pos[1]});
            if(pos[0]+1 <n && board[pos[0]+1][pos[1]] == 'O')
                queue.offer(new int[]{pos[0]+1, pos[1]});
            if(pos[1]-1 >=0 && board[pos[0]][pos[1]-1] == 'O')
                queue.offer(new int[]{pos[0], pos[1]-1});
            if(pos[1]+1 <m && board[pos[0]][pos[1]+1] == 'O')
                queue.offer(new int[]{pos[0], pos[1]+1});
        }
        for(int i = 0 ;i < n ;i++){
            for(int j = 0 ; j< m ;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

}
