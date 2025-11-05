package com.maji.maojianwei.leetcode.format.slide_window;


public class Test {

    public static void main(String[] args){
        MaxSeriesOne maxSeriesOne = new MaxSeriesOne();
        int[] array = {1, 0, 0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(maxSeriesOne.solutionOne(array, 2));
    }

}
