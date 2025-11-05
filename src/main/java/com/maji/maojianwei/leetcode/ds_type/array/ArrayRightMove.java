package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 数组向右移动m，希望原位实现
 * 【1 2 3 4 5 6】 2 -> 【5 6 1 2 3 4】
 *
 */
public class ArrayRightMove {

    /**
     * 先翻转整个数组，
     * 然后翻转前m部分
     * 最后翻转后n-m部分
     *
     * 另外简单的思路，包括每次向右移动一位，移动m次，移动次数较多
     */
    public int[] solve (int n, int m, int[] a) {
        m = m%n;
        traverse(a, 0, n-1);
        traverse(a, 0, m-1);
        traverse(a, m, n-1);
        return a;
    }

    public void traverse(int[] data, int left, int right){
        while(left < right){
            int tmp = data[left];
            data[left] = data[right];
            data[right] = tmp;
            left++;
            right--;
        }
    }
}
