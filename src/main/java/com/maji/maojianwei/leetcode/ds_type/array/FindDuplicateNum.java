package com.maji.maojianwei.leetcode.ds_type.array;

import java.util.Arrays;

/**
 * 287
 * desc:给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数
 **/

public class FindDuplicateNum {

    /**
     * 哈希算法： 空间代价很高
     */
    public int findDuplicate1(int[] nums){
        int n = nums.length;
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, false );
        for( int i = 0 ;i < n; i++){
            if(arr[nums[i]]){
                return nums[i];
            }
            else{
                arr[nums[i]] = true;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     *   二分查找法，时间稍高，常量空间
     */
    public static int findDuplicate2(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            int count = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    /**
     *  快慢指针， 时间为n, 空间常量。
     *  逻辑： 考虑到索引和值是有映射关系的，如果通过索引遍历比如1 2 4 3 5    0 -> 1 -> 2 -> 4 -> 5
     *        如果存在重复的元素，则一定成环， 且重复元素是环的入口，
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);  // 先相遇
        slow = 0;
        while (slow != fast) { // 再找入口
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


}
