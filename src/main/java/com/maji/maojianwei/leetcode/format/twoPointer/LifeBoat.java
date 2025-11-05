package com.maji.maojianwei.leetcode.format.twoPointer;

import java.util.Arrays;

/**第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 返回载到每一个人所需的最小船数。(保证每个人都能被船载)
 输入：people = [3,2,2,1], limit = 3
 输出：3
。
 * @Author maojianwei
 * @Date 2020/8/11 17:11
 **/
public class LifeBoat {
    /* 双指针 相向， 利用了贪心思路，最重得的人总是试图搭配最轻的，不行就自己一个人走*/
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatNum = 0;
        int i = 0;
        int j = people.length-1;
        while(i<j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            boatNum++;
        }
        if( i == j){
            boatNum++;
        }
        return boatNum;
    }
}
