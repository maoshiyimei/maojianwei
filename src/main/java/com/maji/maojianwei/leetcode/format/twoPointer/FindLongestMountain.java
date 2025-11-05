package com.maji.maojianwei.leetcode.format.twoPointer;

/**我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

 B.length >= 3
 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
例如：输入：[2,1,4,7,3,2,5]
     输出：5
 * @Author maojianwei
 * @Date 2020/8/11 14:54
 **/
public class FindLongestMountain {

    /**
     * 双指针： 简单的思想，就是每一个山峰一个山峰的找， 中间标识找到山峰了。每到峰底就更新
     * @param array
     * @return
     */
    public static int[] findLongestPeak(int[] array){
        if(array == null || array.length < 3){
            return null;
        }
        int maxLength = 0;
        int maxLeft = 0;
        int left = 0;
        int right = 1;
        boolean hasPeak = false;
        while(right < array.length){
            //如果是峰底或者结束了：清算，重新开始
            if(right == array.length -1 || array[right] < array[right-1] && array[right] < array[right+1] ){
                if(hasPeak && right - left + 1 > maxLength){
                    maxLength = right -left +1;
                    maxLeft = left;
                    hasPeak = false;
                }
                left = right;
            }
            // 如果是封顶：标记找到山峰了
            else if(array[right]> array[right-1] && array[right] > array[right+1]){
                hasPeak = true;
            }
            right++;
        }
        int[] res = new int[maxLength];
        for(int i = 0 ;i< maxLength; i++){
            res[i] = array[maxLeft++];
        }
        return res;
    }

    /**
     * 双指针： 每次都判断是否是封顶，两个相反指针，存在重复遍历（左侧两遍）
     * @param array
     * @return
     */
    public static int[] findLongestPeak2(int[] array){
        if(array == null || array.length < 3){
            return null;
        }
        int maxLength = 0;
        int maxLeft = 0;
        for(int i = 1; i< array.length -1; ){
            //如果是封顶，则开始两边延申
            if(array[i] > array[i-1] && array[i] > array[i+1]){
                int left = i-1;
                int right = i+1;
                while(left-1 >=0 && array[left] > array[left-1]){
                    left--;
                }
                while(right+1<array.length && array[right] > array[right+1]){
                    right++;
                }
                if(right -left + 1 > maxLength){
                    maxLength = right-left+1;
                    maxLeft = left;
                }
                i = right + 1;
            }
            // 这里快速跳跃，可以减少重复遍历
            else{
                i++;
            }
        }
        int[] res = new int[maxLength];
        for(int i = 0 ;i< maxLength; i++){
            res[i] = array[maxLeft++];
        }
        return res;
    }
}
