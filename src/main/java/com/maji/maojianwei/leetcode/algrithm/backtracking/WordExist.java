package com.maji.maojianwei.leetcode.algrithm.backtracking;

/**
 * 79. 单词搜索
 * 中等
 * 1.7K
 * 相关企业
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 */
public class WordExist {
    /**
     * 回溯
     * 为了避免重复使用可以先改成特殊字符或者利用另一个数组保存状态
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if ( n == 0){
            return false;
        }
        int m = board[0].length;
        char[]chars =word.toCharArray();
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ; j< m ;j ++){
                if (board[i][j] == chars[0]){
                    if (dfs(board, chars, 0, 0, 0 )){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] chars, int idx, int row, int col){
        if(board[row][col] != chars[idx]){
            return false;
        }
        if (idx == chars.length-1) {
            return true;
        }
        board[row][col] = '*';

        boolean res  = false;
        if (row-1>=0){
             if(dfs(board, chars, idx + 1, row - 1, col)){
                 board[row][col] = chars[idx];
                 return true;
             }
        }
        if (row+1<board.length){
            if(dfs(board, chars, idx + 1, row + 1, col)){
                board[row][col] = chars[idx];
                return true;
            }
        }

        if (col+1<board[0].length){
            if(dfs(board, chars, idx + 1, row, col+1)){
                board[row][col] = chars[idx];
                return true;
            }
        }

        if (col-1>=0){
            if(dfs(board, chars, idx + 1, row, col-1)){
                board[row][col] = chars[idx];
                return true;
            }
        }


        board[row][col] = chars[idx];
        return false;
    }
}
