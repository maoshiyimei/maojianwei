package com.maji.maojianwei.leetcode.format.twoPointer;

/**给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数（重复次数不限于一次）找出这个重复的数。

 * @Author maojianwei
 * @Date 2020/8/12 19:11
 **/
public class FineOnlyRepeatNum {

    /* 双指针法 ： 首先按 i - > nums[i] 一定可以构建一个包含环的链表，
    * 注意整个链表并不一定包含所有值，但是一定包含重复匀速（环入口）
    * 下面就可以采用Floyd判圈法找到这个入口
    * 时间效率较高 线性时间 */
    public int findDuplicate(int[] nums) {
        if(nums.length <= 2){
            return nums[0];
        }
        int i = 0,j = 0;
        while(true){
            i = nums[i];
            j = nums[nums[j]];
            if(i == j)  { break;}
        }
        i = 0;
        while(true){
            i = nums[i];
            j = nums[j];
            if(i == j) break;
        }
        return i;
    }

    /* 因为特殊性，可以用二分查找，结合抽屉原理*/
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java.txt 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right)/2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

}
