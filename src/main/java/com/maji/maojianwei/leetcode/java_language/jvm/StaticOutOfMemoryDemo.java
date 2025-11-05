package com.maji.maojianwei.leetcode.java_language.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/18 , 14:15
 */
public class StaticOutOfMemoryDemo {
    public static Random random = new Random();

    public static List<Double> list = new ArrayList<>(100000000);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0 ;i< 100000000 ;i ++){
                list.add( random.nextDouble());
        }
        System.gc();
        Thread.sleep(1000);
    }
}
