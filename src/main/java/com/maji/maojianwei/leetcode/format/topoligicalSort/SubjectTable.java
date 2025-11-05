package com.maji.maojianwei.leetcode.format.topoligicalSort;


import java.util.*;

/**
 * 207
 * desc: 课程表中的课程为 0 ～ n-1， 给定先修课程的列表数组，求是否可以完成全部课程的学习
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 */
public class SubjectTable {

    /**
     * 问题等价于，先修课程的关系数组中是否存在循环依赖，不存在则可以完成所有课程的学习。
     * 或者 给定一个包含 n 个节点的有向图 G( 包含m 条边）， 图中是否存在环
     * 时间复杂度最优为 O（n + m ）
     */


    /**
     * 方法1： BFS, 借助队列， 存储的入度为0的节点， 存储使用邻接表
     */
    public static boolean canFinish(int numCourses, int[][] preconditions){
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        // 每一个课程都有一个列表
        for(int i = 0 ; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        // 计算入度 和 存储图
        for(int[] precondition : preconditions){
            inDegree[precondition[1]]++;
            adjList.get(precondition[0]).add(precondition[1]);
        }

        // 找到所以入度为0 的起始点
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i< numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        // 对每一个root其孩子都入度减一
        while(!queue.isEmpty()){
            int cur = queue.poll();
            numCourses--;
            for(int child : adjList.get(cur)){
                inDegree[child]--;
                if(inDegree[child] == 0){
                    queue.offer(child);
                }
            }
        }
        return numCourses == 0;
    }

    /**
     * 方法2： DFS, 递归写法， 不需要从入度为0的点出发， 存储使用邻接表
     */
    public static boolean canFinish2(int numCourses, int[][] preconditions){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        // 存储图
        for(int[] precondition : preconditions){
            adjList.get(precondition[0]).add(precondition[1]);
        }
        int[] status = new int[numCourses];
        for(int i = 0 ; i< numCourses; i++){
            if(status[i] == 0){
                if(!dfs(i, adjList, status)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * dfs : status 维持三种访问状态 0 表示未访问， 1表示正在深度遍历中， 2表示应便利完成了
     * @param k
     * @param adjList
     * @param status
     * @return
     */
    public static boolean dfs(int k, List<List<Integer>> adjList, int[] status){
        status[k] = 1;
        for(int child : adjList.get(k)){
            if(status[k] == 0){
                 if(!dfs(child, adjList, status)){
                     return false;
                 }
            } else if(status[child] == 1){
                return false;
            }
        }
        status[k] = 2;
        return true;
    }

    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        //先构造邻接矩阵
        int [][] AdjacencyMatrix=new int[numCourses][numCourses];
        int [] visited=new int[numCourses];//访问情况记录,dfs的时候，0：尚未访问过；1：在其他节点为起始的时候访问过了；2：在当前节点起始的时候访问过了，有环，直接返回false
        for (int [] pre:prerequisites) {
            AdjacencyMatrix[pre[1]][pre[0]]=1;//pre[1]指向pre[0]的一条边
        }
        for(int i=0;i<numCourses;i++){//对节点i
            if(visited[i]==0) {
                if (!dfs2(AdjacencyMatrix, visited, i))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs2(int [][] AdjacencyMatrix,int [] visited,int i){
        if(visited[i]==2)
            return false;//在主循环的一轮dfs中访问了同一个节点两次，有回路
        visited[i]=2;
        for(int j=0;j<AdjacencyMatrix.length;j++){
            if(AdjacencyMatrix[i][j]==1){
                if(dfs2(AdjacencyMatrix,visited,j)==false)
                    return false;
            }
        }
        visited[i]=1;//从节点i开始的dfs结束
        return true;
    }

    /**
     * 输出一个拓扑序列，任意一个
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int k = 0;
        int[] inDegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0 ;i< numCourses; i++){
            edges.add(new ArrayList<>());
        }

        for(int[] relation : prerequisites){
            inDegree[relation[0]]++;
            edges.get(relation[1]).add(relation[0]);
        }
        Queue<Integer> roots = new LinkedList<>();
        for(int i = 0 ; i< numCourses; i++){
            if(inDegree[i] == 0){
                roots.offer(i);
            }
        }

        while(!roots.isEmpty()){
            int root = roots.poll();
            res[k++] = root;
            numCourses--;
            for(int next : edges.get(root)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    roots.offer(next);
                }
            }
        }
        if(numCourses == 0){
            return res;
        }
        else{
            return new int[0];
        }
    }
}
