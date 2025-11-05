package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 575
 * desc:给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果
 */
public class SeparateCandi {


    /**
     * 直接计算种类，妹妹分得的最大种类要么是总种类数量，要们是一半的数量
     */
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> type = new HashSet<>();
        for(int i = 0 ;i< n; i++){
            type.add(candyType[i]);
        }
        return type.size() > n/2? n/2: type.size();
    }

}
