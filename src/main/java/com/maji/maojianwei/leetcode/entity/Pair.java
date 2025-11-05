package com.maji.maojianwei.leetcode.entity;

/**
 * @Author maojianwei
 * @Date 2020/8/12 18:21
 **/
public class Pair implements Comparable<Pair>{
    public int x = 0 ;
    public int y = 0 ;
    public Pair(int x, int y ){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(p.x - this.x > 0){
            return -1;
        }
        else if(p.x - this.x == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

}
