package com.maji.maojianwei.leetcode.format.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47
 * desc: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class AllRangeAllowRepeat2 {

    public static List<int[]> permuteUnique(int[] nums) {
        List<int[]> ans = new ArrayList<>();
        backtrack(nums, ans, 0);
        return ans;
    }

    /**
     * 这种方法是错误的： 因为每次不是全局考虑的， 虽然直观上不会相同的元素进行交换，
     * 但是除了这种情况， 还会由其他交换产生相同的
     * @param nums
     * @param ans
     * @param idx
     */
    public static void backtrack(int[] nums, List<int[]> ans, int idx) {
        if (idx == nums.length) {
            int[] cur = new int[nums.length];
            for(int i =0; i< cur.length; i++){
                cur[i] = nums[i];
            }
            ans.add(cur);
            return;
        }

        for( int i = idx; i< nums.length; i++){

            if( idx-1 > 0 && nums[idx-1] == nums[i] || idx != i && nums[i] == nums[idx] ){
                continue;
            }
            else{
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;

                backtrack(nums, ans, idx+1);

                temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            }
        }


    }

}
