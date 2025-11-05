package com.maji.maojianwei.leetcode.format.BFS;

import java.util.*;

/**给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 * 答案只能是 1， ，2 ，3， 4
 * @Author maojianwei
 * @Date 2020/7/30 13:55
 **/
public class NumsSquare {
    public static void main(String[] args){
        System.out.println( numSquares2(42));

    }
    /* 直接使用BFS, 时间超限，复杂度过高 */
    public static int numSquares1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;
        for( int i =1 ; i*i <= n ;i++){
            queue.offer(n - i*i );
        }
        while(!queue.isEmpty()){
            num++;
            int num_level  = queue.size();
            for( int i = 0 ; i <num_level ;i++){
                int remain = queue.poll();
                if(remain == 0){
                    return num;
                }
                else{
                    for( int j = 1 ; j*j <= remain ;j++){
                        queue.offer(remain - j*j);
                    }
                }
            }
        }
        return num;
    }

    /* 对BFS进行优化，避免重复计算 使用数据结构不合适，且不够简化 */
    public static int numSquares2(int n) {
        int count = 0;
        Set<Integer> level_cur = new HashSet<>();
        level_cur.add(n);
        while(!level_cur.isEmpty()){
            count++;
            int num_level = level_cur.size();
            List<Integer> level_nums = new ArrayList<>(level_cur);
            level_cur.clear();
            for( int i = 0 ; i <num_level ;i++){
                int value = level_nums.get(i);
                for(int j = 1; j*j <= value; j++){
                    if(value-j*j == 0){
                        return count;
                    }
                    if(!level_cur.contains(j*j)){
                        level_cur.add(value -j*j);
                    }
                }
            }
        }
        return count;
    }

    /* 对BFD再次优化，建立一个全局的visited数组来实现剪枝*/
    public static int numSquares3(int n){
        if(n<4)return n;
        int ans = 0;
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[n];

        queue.add(n);//初始的根从n开始
        while( !queue.isEmpty() ){
            ans++;
            int size = queue.size();
            for( int i = 0 ; i <size ; i++ ){
                int cur = queue.remove();
                System.out.print(cur + " ");
                for( int j = 1 ; j*j<=cur ; j++ ){
                    if( cur-j*j == 0 )return ans;
                    if( !visited[cur-j*j] ){
                        visited[cur-j*j]=true;
                        queue.add(cur-j*j);
                    }
                }
            }
            System.out.println();
        }
        return ans;
    }

    /* 基于数学原理的方法， 一个数一定可以用不超过四个平方数来表示，
       还有一个非常重要的推论满足四数平方和定理的数n（这里要满足由四个数构成，小于四个不行），
       必定满足 n = 4a * (8b + 7)。*/
    public static int numSquares4(int n ){
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        if (isSquare(n))
            return 1;
        for (int i = 1; i * i <= n; ++i) {
            if (isSquare(n - i * i))
                return 2;
        }
        return 3;

    }

    protected static boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }


}
