package com.maji.maojianwei.leetcode.ds_type.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * 先统计频率，然后使用堆选择前k个即可
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for( int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /**
         * 默认的顺苏是小根堆，
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for(int num : map.keySet()){
            heap.offer(num);
        }

        int[] res = new int[k];
        // 取出前K个
        for (int i = 0; i < k ; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
