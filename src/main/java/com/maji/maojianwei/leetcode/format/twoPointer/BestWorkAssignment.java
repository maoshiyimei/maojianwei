//package com.maji.maojianwei.leetcode.format.twoPointer;
//
//import java.util.Arrays;
//
///**
// * @Author maojianwei
// * @Date 2020/8/12 18:13
// **/
//public class BestWorkAssignment {
//    /* 双指针 ： 难度和收益建立哈希，然后分别排序，一个指针为工人指针，一个为难度指针，均不断增加*/
//    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//        int N = difficulty.length;
//        Pair[] jobs = new Pair[N];
//        for (int i = 0; i < N; ++i)
//            jobs[i] = new Pair(difficulty[i], profit[i]);
//        Arrays.sort(jobs);
//        Arrays.sort(worker);
//        int ans = 0, i = 0, best = 0;
//        for (int skill: worker) {
//            while (i < N && skill >= jobs[i].x){
//                best = Math.max(best, jobs[i++].y);
//            }
//            ans += best;
//        }
//
//        return ans;
//    }
//    class Pair implements Comparable<entity.Pair>{
//        public int x = 0 ;
//        public int y = 0 ;
//        public Pair(int x, int y ){
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int compareTo(entity.Pair p) {
//            if(p.x - this.x > 0){
//                return -1;
//            }
//            else if(p.x - this.x == 0){
//                return 0;
//            }
//            else{
//                return 1;
//            }
//        }
//
//    }
//
//    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
//        int LEN = 0, curMax = 0, sum = 0;
//
//        for (int w: worker) LEN = Math.max(LEN, w);
//        int res[] = new int[LEN + 1];
//        //计算出相同难度上，收益最大值是多少
//        //res:0 0 10 0 20 0 30
//        for (int i = 0; i < difficulty.length; i++) {
//            if (difficulty[i] > LEN) continue;
//            res[difficulty[i]] = Math.max(profit[i], res[difficulty[i]]);
//        }
//        //res:0 0 10 0 20 0 30
//        for (int i = 0; i <= LEN; i++) {
//            if (res[i] > curMax) curMax = res[i];
//            else res[i] = curMax;
//        }
//        //res:0 0 10 10 20 20 30
//        for (int w: worker) sum += res[w];
//
//        return sum;
//    }
//
//
//}
