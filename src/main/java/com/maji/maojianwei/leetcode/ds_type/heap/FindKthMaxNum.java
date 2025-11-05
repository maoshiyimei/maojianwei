package com.maji.maojianwei.leetcode.ds_type.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthMaxNum {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        // 堆存储成完全二叉树， 使用数组原位存储
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            //删除对顶元素， size-1
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    /**
     * 第一次构建的时候需要从下到上每一层都调整, 保证整体满足堆的性质
     * @param a
     * @param heapSize
     */
    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    /**
     * 向下调整， 交换则继续向下判断
     * @param a
     * @param i
     * @param heapSize
     */
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * 使用默认的堆
     * @param nums
     * @param k
     * @return
     */
    public int find2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums){
            heap.offer(num);
        }
        for(int i = 0; i < k ;i++){
            int tempNum = heap.poll();
            if(i == k-1){
                return tempNum;
            }
        }

        return 0;
    }

}
