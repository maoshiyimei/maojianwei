package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 中等
 * 2.2K
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

public class MergeIntervals {

    /**
     * 思路： 线排序， 然后遍历一遍即可
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }

        // 按左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        // 遍历
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(intervals[0][0], intervals[0][1])));
        for( int i = 1 ; i < intervals.length; i++) {
            ArrayList<Integer>  foreInterval = res.get(res.size()-1);
            if (foreInterval.get(1) < intervals[i][0]) {
                res.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
            } else {
                 foreInterval = new ArrayList<>(Arrays.asList(foreInterval.get(0), Math.max(intervals[i][1], foreInterval.get(1))));
                 res.set(res.size()-1, foreInterval);
            }
        }

        // 输出
        return res.toArray( new int[res.size()][2]);

    }
}
