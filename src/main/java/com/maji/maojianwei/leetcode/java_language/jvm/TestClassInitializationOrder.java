package com.maji.maojianwei.leetcode.java_language.jvm;

import com.maji.maojianwei.leetcode.entity.Animal;
import com.maji.maojianwei.leetcode.entity.Tiger;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/26 , 15:27
 */
public class TestClassInitializationOrder {
    public static void main(String[] args){
        Animal tiger = new Tiger();
        Animal tiger2 = new Tiger();
    }


}
