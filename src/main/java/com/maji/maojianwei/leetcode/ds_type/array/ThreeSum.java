package com.maji.maojianwei.leetcode.ds_type.array;


import java.util.*;

/**
 *15. 三数之和
 * 相关企业
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4] [-4,-1,-1,0,1,2]
 * 输出：[[-1,-1,2],[-1,0,1]]
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>>  res = new ArrayList<>();

        // 先确定第一个数
        for (int one = 0; one < nums.length-2; one++){
            // 每一个只能作为第一个数一次， 不能重复， 且容易得知如果第一个就>0， 后面就可以不用看了
            if (nums[one] >0 ){
                return res;
            }
            if (one > 0 && nums[one] == nums[one-1]) {
                continue;
            }
            // 再确定第二个数和第三个数，这里借助哈希表（ O(N)  )
            Set<Integer> set = new HashSet<>();
            for (int two = one+1; two < nums.length; two++){
                int thirdNum = -(nums[one] + nums[two]);
                if (set.contains(thirdNum)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[one], nums[two], thirdNum)));
                    // 优化避免第二个重复，导致整体重复
                    while(two<nums.length-1 && nums[two] == nums[two+1]) {
                        two++;
                    }
                }
                set.add(nums[two]);

            }
        }
        return res;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 避免第一个重复
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 确定第二个数和第三个数字： 双指针
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;

                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[j]);
                    array.add(nums[k]);
                    res.add(array);
                    j++;
                    k--;
                    // 避免重复
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
