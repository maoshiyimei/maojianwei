package com.maji.maojianwei.leetcode.format.BFS;

import java.util.*;

/**
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * @Author maojianwei
 * @Date 2020/8/4 18:19
 **/
public class TwoIslands {
    /*思路，先找一个岛， 然后找到边缘，每次向外扩散一层，并更新边缘， 直至第一次接触 */

    public static int getShortestDistance(int[][] area){
        boolean[][] visited = new boolean[area.length][area[0].length];
        int[] posIslandOne = getOneIslandStartPos(area);
        visited[posIslandOne[0]][posIslandOne[1]] = true;
        Queue<int[]> islandOneEdge = getIslandOneEdge(area, posIslandOne, visited);
        return spreadIslandOne(area, islandOneEdge, visited);
    }

    /**
     * 找到第一个岛屿的起始位置
     * @param area
     * @return
     */
    public static int[] getOneIslandStartPos(int[][] area){
        for(int i = 0 ; i< area.length; i++){
            for(int j =0 ; j< area[0].length; j++){
                if(area[i][j] == 1){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * bfS遍历小岛1， 并找到边缘位置
     * @param area
     * @param pos
     * @param visited
     * @return
     */
    public static Queue<int[]> getIslandOneEdge(int[][] area, int[] pos,  boolean[][] visited){
        Queue<int[]> island = new LinkedList<>();
        Queue<int[]> edges = new LinkedList<>();
        island.offer(pos);
        while(!island.isEmpty()){
            int size = island.size();
            for(int i = 0 ; i< size; i++){
                int[] curPos = island.poll();
                if(curPos[0] - 1 >= 0 && !visited[curPos[0] - 1][curPos[1]] && area[curPos[0] - 1][curPos[1]] == 1){
                    island.offer(new int[]{curPos[0]-1, curPos[1]});
                    visited[curPos[0] - 1][curPos[1]] = true;
                }
                if(curPos[0] + 1 <area.length  && !visited[curPos[0] + 1][curPos[1]] && area[curPos[0] + 1][curPos[1]] == 1){
                    island.offer(new int[]{curPos[0]+1, curPos[1]});
                    visited[curPos[0] + 1][curPos[1]] = true;
                }
                if(curPos[1] - 1 >= 0 && !visited[curPos[0]][curPos[1] - 1] && area[curPos[0]][curPos[1] - 1] == 1){
                    island.offer(new int[]{curPos[0], curPos[1] - 1});
                    visited[curPos[0]][curPos[1] - 1] = true;
                }
                if(curPos[1] + 1 <area[0].length && !visited[curPos[0]][curPos[1] + 1] && area[curPos[0]][curPos[1] + 1] == 1){
                    island.offer(new int[]{curPos[0], curPos[1] + 1});
                    visited[curPos[0]][curPos[1] + 1] = true;

                }
                //判断是否是边缘：集周围有0的位置

                if((curPos[0] - 1 >= 0 && area[curPos[0] -1][curPos[1]] == 0) ||
                        (curPos[0] + 1 <area.length && area[curPos[0] + 1][curPos[1]] == 0) ||
                        (curPos[1] - 1 >= 0 && area[curPos[0]][curPos[1] - 1] == 0) ||
                        (curPos[1] + 1 <area[0].length && area[curPos[0]][curPos[1] + 1] == 0) ){
                    edges.offer(curPos);
                }
            }
        }
        return edges;
    }

    /**
     * bfs 延申直到找到第一个1
     * @param area
     * @param edges
     * @param visited
     * @return
     */
    public static int spreadIslandOne(int[][] area, Queue<int[]> edges,  boolean[][] visited){
        int distance = 0;
        while(!edges.isEmpty()){
            int size = edges.size();
            for(int i = 0; i<size; i++){
                int[] p = edges.poll();
                if(p[0] - 1 >= 0 && !visited[p[0] - 1][p[1]]){
                    if(area[p[0] - 1][p[1]] == 1){
                        return distance;
                    } else {
                        visited[p[0] - 1][p[1]] = true;
                        edges.offer(new int[]{p[0] - 1, p[1]});
                    }
                }
                if(p[0] + 1 < area.length  && !visited[p[0] + 1][p[1]]){
                    if(area[p[0] + 1][p[1]] == 1){
                        return distance;
                    } else {
                        visited[p[0] + 1][p[1]] = true;
                        edges.offer(new int[]{p[0] + 1, p[1]});
                    }
                }
                if(p[1] - 1 >= 0 && !visited[p[0]][p[1] - 1]){
                    if(area[p[0]][p[1] - 1] == 1){
                        return distance;
                    } else {
                        visited[p[0]][p[1] - 1] = true;
                        edges.offer(new int[]{p[0], p[1] - 1});
                    }
                }
                if(p[1] + 1 < area[0].length && !visited[p[0]][p[1] + 1]){
                    if(area[p[0]][p[1] + 1] == 1){
                        return distance;
                    } else {
                        visited[p[0]][p[1] + 1] = true;
                        edges.offer(new int[]{p[0], p[1] + 1});
                    }
                }
            }
            distance++;
        }
        return distance;
    }

}
