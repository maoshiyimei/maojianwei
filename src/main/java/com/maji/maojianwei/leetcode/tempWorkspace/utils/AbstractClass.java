package com.maji.maojianwei.leetcode.tempWorkspace.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/8 , 12:45
 */
public  class AbstractClass {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList( 1,2,3,4,5,6,7,8,9,10,11,12));
        list.add(100);
        list.add(13);
        List<Integer> newList =Collections.unmodifiableList(list);
// newList.add(13);
//System.out.println( newList.get(12) );

    }
}
