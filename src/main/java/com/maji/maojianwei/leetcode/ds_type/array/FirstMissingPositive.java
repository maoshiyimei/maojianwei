package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * 41. 缺失的第一个正数
 * 提示
 * 困难
 * 2K
 * 相关企业
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 3 4 5 1
 *  3 4 -1 1
 *
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class FirstMissingPositive {

    /**
     * 重要结论： 容易证明， 这个值一定在 1 - N+1之间， 所以可以利用这个数组本身作为索引哈希
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        // 先把负数改成大于等于N+1的值
        int n = nums.length;
        for( int i = 0 ; i < n ; i++) {
            if (nums[i] <= 0 ) {
                nums[i] = n+1;
            }
        }

        // 然后将值范围在1-N之间的位置哈希标志为负（这里之所以只是加个负号而不是直接标志成-1这样的固定数字， 是因为不能丢失值信息， 没有使用额外的空间会丢失数据），
        for( int i = 0 ; i < n; i++){
             int num = Math.abs(nums[i]);
            if (num<= n){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }

         //返回结果
        for( int i = 0 ; i < n ; i++) {
            if (nums[i] > 0 ){
                return i + 1;
            }
        }
        return n+1;

    }

    // 置换： 该方法的核心是，每次都将一个1-N之间的数字放在其最终位置上上， 这样最后的序列一定是连续的， 不满足连续顺序的自然就是确实的数据
    //* 输入：nums = [3,4,-1,1]
    /**
     * -1 4 3 1
     * -1 1 3 4
     * 1 -1 3 4
     *
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0 ; i< n ; i++){
            while(nums[i] >0 && nums[i] <= n &&  nums[nums[i]- 1] != nums[i] ){
                int temp = nums[nums[i]-1];
                nums[nums[i] -1 ] = nums[i];
                nums[i] = temp;
            }
        }

        for ( int i = 0 ; i < n ; i++){
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        return  n +1;
    }



}
