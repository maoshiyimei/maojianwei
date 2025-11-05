package com.maji.maojianwei.leetcode.ds_type.array; /**
 * Class:假设你是一位很有爱的幼儿园老师，想要给幼儿园的小朋友们一些小糖果。
 * 但是，每个孩子最多只能给一块糖果。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的糖果的最小尺寸；并且每块糖果 j ，都有一个尺寸 sj 。如果 sj >= gi ，
 * 我们可以将这个糖果 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 1 2 3
 * 1 1 - > 1
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/19 , 21:24
 */
import java.util.*;

public class SeparateCandi3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String g = in.nextLine();
        String s = in.nextLine();
        String[] arrayG = g.split("\\s+");
        String[] arrayS = s.split("\\s+");
        List<Integer> listG = new ArrayList<>();
        List<Integer> listS = new ArrayList<>();
        for(String sunString : arrayG){
            listG.add(Integer.valueOf(sunString));
        }
        for(String sunString : arrayS){
            listS.add(Integer.valueOf(sunString));
        }
        System.out.println(solution(listG, listS));
    }
    /* 贪心思路: 注意当该糖果不满足时还要继续完全遍历糖果 */
    public static int solution(List<Integer> listG, List<Integer> listS){
        Collections.sort(listG);
        Collections.sort(listS);
        int n = listG.size();
        int m = listS.size();
        int count=0;
        for(int i = 0, j = 0 ; i < m && j < n ; i++){
            if(listS.get(i) >= listG.get(j) ){
                count++;
                j++;
            }
        }
        return count;
    }
}
