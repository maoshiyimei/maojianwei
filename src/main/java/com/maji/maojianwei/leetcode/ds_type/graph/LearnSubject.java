package com.maji.maojianwei.leetcode.ds_type.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LearnSubject {
    /**
     * bfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储图
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        //统计入度
        int[] inDegree = new int[numCourses];
        for (int[] info : prerequisites) {
            //要学习info[0]，需要先学习info[1]，
            edges.get(info[1]).add(info[0]);
            ++inDegree[info[0]];
        }

        //选择入度为0的
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 统计可以完成的课程
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --inDegree[v];
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i< numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            count++;
            for(int edge : edges.get(idx)){
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return count == numCourses;

    }
}
