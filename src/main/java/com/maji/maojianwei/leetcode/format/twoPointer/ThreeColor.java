package com.maji.maojianwei.leetcode.format.twoPointer;

import com.maji.maojianwei.leetcode.utils.ArrayUtil;

/**给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
。输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 不使用排序
 * @Author maojianwei
 * @Date 2020/8/12 16:23
 **/
public class ThreeColor {
    /*
    三指针法， i指向最后一个0，cur为工作指针， j指向第一个2
     */
    public static void sort(int[] colors){
        int i = -1;
        int j = colors.length;
        int cur = 0;
        while(cur<j && cur < colors.length){
            // 1 则继续往前
            if(colors[cur] == 1){
                cur++;
            } else if(colors[cur] == 0){
                i++;
                colors[cur] = colors[i];
                colors[i] = 0;
                // 这里因为 cur >= i , 当 cur = i , color[cur] = 0 说明到现在都四0,当 cur > i , color[cur] = 1,
                cur++;
            } else{
                j--;
                colors[cur] = colors[j];
                colors[j] = 2;
            }
            ArrayUtil.printArray(colors);
        }
    }

}
