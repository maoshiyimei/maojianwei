package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;


public class TestMain {
    public static int time = 0;
    public static int minTime = Integer.MAX_VALUE;
    public static int n;
    public static int m;
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        in.nextLine();
//
//        Arrays.fill(board[0], '0');
//        int startRow = 0;
//        int startCol = 0;
//        int endRow = 0;
//        int endCol = 0;
//        for(int i = 1 ;i <= n ; i++){
//            Arrays.fill(board[i], '0');
//            String s = in.nextLine();
//            for( int j = 1 ; j <= m ; j ++){
//                char ch = s.charAt(j-1);
//                board[i][j] = ch;
//                if(ch == 'S'){
//                    startRow = i;
//                    startCol = j;
//                }
//            }
//        }
//        solution(startRow, startCol, 5);
//        if(minTime == Integer.MAX_VALUE){
//            System.out.println(-1);
//        }
//        else{
//            System.out.println(  minTime );
//        }
//
//    }
//    public static void solution(int row , int col, int k) {
//        if(board[row][col] == 'E'  || time > 99999){
//            if(time < minTime ){
//                minTime = time;
//            }
//        }
//        else{
//            if( row-1 >=1 && board[row-1][col] == '.'){
//                time++;
//                solution(row-1, col, k);
//                time--;
//            }
//            if( col-1 >=1 && board[row][col-1] == '.'){
//                time++;
//                solution(row, col-1, k);
//                time--;
//            }
//            if( row+1 <= n && board[row+1][col] == '.'){
//                time++;
//                solution(row+1, col, k);
//                time--;
//            }
//            if( col+1 <= m  && board[row][col+1] == '.'){
//                time++;
//                solution(row, col+1, k);
//                time--;
//            }
//            if( k>0 && canJump(row, col)){
//                time++;
//                k--;
//                solution(n+1-row, m+1-col, k-1);
//                k++;
//                time--;
//            }
//
//
//        }
//    }
//    public static boolean hasChoice(int row , int col){
//
//        int n = board.length;
//        int m = board[0].length;
//        if( row-1 >=1 && board[row-1][col] == '.'){
//            return true;
//        }
//        if( col-1 >=1 && board[row][col-1] == '.'){
//            return true;
//        }
//        if( row+1 <= n && board[row+1][col] == '.'){
//            return true;
//        }
//        if( row-1 <=m && board[row][col+1] == '.'){
//            return true;
//        }
//        return false;
//    }
//    public static boolean canJump(int row , int col){
//        int newRow = n+1 - row;
//        int newCol = m+1 - col;
//        if(board[newRow][newCol] == '.'){
//            return true;
//        }
//        return false;
//    }
//


}
