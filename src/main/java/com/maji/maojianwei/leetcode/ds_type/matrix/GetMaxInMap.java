package com.maji.maojianwei.leetcode.ds_type.matrix;

import com.maji.maojianwei.leetcode.utils.MatrixUtil;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * (1)给一个矩阵， 只包含 0 1 ， 其中1表示水域 0 表示陆地
 * （2）现在开始对矩阵进行改造：
 *    要求水域固定为 0 ，
 *    陆地可以自由设置整数， 但是要求相邻节点不能高度相差超过1
 *    求可以满足的最高高度；
 *   例子：
 *   输入：isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * 输出：[[1,1,0],[0,1,1],[1,2,2]]
 * 解释：所有安排方案中，最高可行高度为 2 。
 */
public class GetMaxInMap {

    /**
     * 以水域为中心，开始每一次往外扩张， 每次加一，最后全部完成即可
     * @param map
     * @return
     */
    public static int getMaxHeight(int[][] map){
        int[][] board = new int[map.length][map[0].length];
        Queue<int[]> frontier = new LinkedList<>();
        for(int i = 0 ;i < map.length; i++){
            for(int j = 0 ; j < map[0].length; j++){
                if(map[i][j] == 1){
                    frontier.offer(new int[]{i, j});
                    board[i][j] = -1;
                }
            }
        }
        int count  = 0;
        while(!frontier.isEmpty()){
            MatrixUtil.print(board);
            int n = frontier.size();
            for(int i = 0 ; i< n; i++){
                int[] pos = frontier.poll();
                board[pos[0]][pos[1]] = -1;
                if( pos[0] - 1 >= 0 && board[pos[0]-1][pos[1]] != -1){
                    frontier.offer(new int[]{pos[0] -1, pos[1]});
                    board[pos[0] - 1][pos[1]] = -1;
                }
                if( pos[0] + 1 < board.length && board[pos[0]+1][pos[1]] != -1){
                    frontier.offer(new int[]{pos[0] + 1, pos[1]});
                    board[pos[0] + 1][pos[1]] = -1;
                }
                if( pos[1] - 1 >= 0 && board[pos[0]][pos[1] - 1] != -1){
                    frontier.offer(new int[]{pos[0], pos[1] - 1});
                    board[pos[0]][pos[1] -1] = -1;
                }
                if( pos[1] + 1 < board[0].length  && board[pos[0]][pos[1] + 1] != -1){
                    frontier.offer(new int[]{pos[0], pos[1] + 1});
                    board[pos[0]][pos[1] + 1] = -1;
                }
            }
            count++;
            System.out.println(count);
        }
        return count-1;

    }

    /**
     * 输出结果： 同样的方法
     * @param map
     * @return
     */
    public static int[][] getMaxHeight2(int[][] map){
        int[][] board = new int[map.length][map[0].length];
        for(int i = 0 ;i < map.length; i++){
            Arrays.fill(board[i], -1);
        }
        Queue<int[]> frontier = new LinkedList<>();
        for(int i = 0 ;i < map.length; i++){
            for(int j = 0 ; j < map[0].length; j++){
                if(map[i][j] == 1){
                    frontier.offer(new int[]{i, j});
                    board[i][j] = 0;
                }
            }
        }
        int count  = 1;
        while(!frontier.isEmpty()){
            MatrixUtil.print(board);
            int n = frontier.size();
            for(int i = 0 ; i< n; i++){
                int[] pos = frontier.poll();
                if( pos[0] - 1 >= 0 && board[pos[0]-1][pos[1]] == -1){
                    frontier.offer(new int[]{pos[0] -1, pos[1]});
                    board[pos[0] - 1][pos[1]] = count;
                }
                if( pos[0] + 1 < board.length && board[pos[0]+1][pos[1]] == -1){
                    frontier.offer(new int[]{pos[0] + 1, pos[1]});
                    board[pos[0] + 1][pos[1]] = count;
                }
                if( pos[1] - 1 >= 0 && board[pos[0]][pos[1] - 1] == -1){
                    frontier.offer(new int[]{pos[0], pos[1] - 1});
                    board[pos[0]][pos[1] -1] = count;
                }
                if( pos[1] + 1 < board[0].length  && board[pos[0]][pos[1] + 1] == -1){
                    frontier.offer(new int[]{pos[0], pos[1] + 1});
                    board[pos[0]][pos[1] + 1] = count;
                }
            }
            count++;
        }
        return board;
    }
}
