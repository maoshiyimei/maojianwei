package com.maji.maojianwei.leetcode.format.backtracking;

public class FindStringInMatrix {


    /**
     * 回溯： 效率较低
     */
    public static boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();
        for(int i = 0 ; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(board[i][j] == letters[0]){
                    if(dfs(board, i, j, letters, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int row, int col,char[] letters,  int k){

        if( k == letters.length-1){
            return true;
        }

        // 为避免之后的重复使用相同元素
        board[row][col] = '*';
        k++;
        boolean result = false;
        if(row - 1>= 0 && board[row-1][col]!='*' && board[row-1][col] == letters[k]){
           result =  dfs(board, row-1, col, letters, k);
        }
        if(!result && row + 1< board.length && board[row+1][col]!='*' && board[row+1][col] == letters[k]){
            result = dfs(board, row+1, col, letters, k);
        }
        if(!result && col - 1>= 0 && board[row][col-1]!='*' && board[row][col-1] == letters[k]){
            result = dfs(board, row, col-1, letters, k);
        }
        if(!result && col + 1< board[0].length && board[row][col+1]!='*' && board[row][col+1] == letters[k]){
            result = dfs(board, row, col+1, letters, k);
        }
        board[row][col] = letters[k-1]; //恢复
        return result;
    }

    /**
     * 代码的优化：不修改原数组使用辅助空间判断
     */
    public boolean exist2(char[][] board, String word) {
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    isUsed[i][j] = true;
                    if(dfs(board,word,isUsed,i,j,1)){
                        return true;
                    }
                    isUsed[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word,boolean[][] isUsed,int i,int j,int depth){
        if(depth == word.length()){
            return true;
        }
        if(j<board[0].length-1&&!isUsed[i][j+1]&&board[i][j+1] == word.charAt(depth)){
            isUsed[i][j+1] = true;
            if(dfs(board,word,isUsed,i,j+1,depth+1)){
                return true;
            }
            isUsed[i][j+1] = false;
        }
        if(i<board.length-1&&!isUsed[i+1][j]&&board[i+1][j] == word.charAt(depth)){
            isUsed[i+1][j] = true;
            if(dfs(board,word,isUsed,i+1,j,depth+1)){
                return true;
            }
            isUsed[i+1][j] = false;
        }
        if(j>0&&!isUsed[i][j-1]&&board[i][j-1] == word.charAt(depth)){
            isUsed[i][j-1] = true;
            if(dfs(board,word,isUsed,i,j-1,depth+1)){
                return true;
            }
            isUsed[i][j-1] = false;
        }
        if(i>0&&!isUsed[i-1][j]&&board[i-1][j] == word.charAt(depth)){
            isUsed[i-1][j] = true;
            if(dfs(board,word,isUsed,i-1,j,depth+1)){
                return true;
            }
            isUsed[i-1][j] = false;
        }
        return false;
    }
}
