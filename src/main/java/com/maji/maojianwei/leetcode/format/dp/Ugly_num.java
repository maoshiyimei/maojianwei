package com.maji.maojianwei.leetcode.format.dp;

/**
 * 263
 * desc: 编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。1 是丑数
 */
public class Ugly_num {


    /**
     * 判断是否是丑数
     */
    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        while(n%2==0){
            n/=2;
        }
        while(n%3 == 0){
            n/=3;
        }
        while(n%5 == 0){
            n/=5;
        }
        return n == 1;
    }


    /**
     * 264
     * 找出第n个丑数: 动态规划的优化
     * 因为计算第n个丑数，一定是之前的某一个丑数 * 2 或3或5得到的，至于是哪一个，选择哪一个因子是关键，比较繁琐；
     * 思路： 假设当前又一个丑数是A* 2 得到，那么下一个满足要求可以*2的自然只有下一个，这里三个指针就是指向的最小的可以*2或3或5的位置，之前的都不用考虑，所以不用创建空间
     *
     */
    public int nthUglyres(int n) {
        if(n == 1){
            return 1;
        }
        int[] res = new int[n+1];
        res[1] = 1;
        int i =2;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        while( i <= n ){
            int min = Math.min( res[index2]*2, res[index3] *3);
            min = Math.min(min, res[index5]*5 );
            if( min == res[index2] * 2 ){
                index2++;
            }
            if( min == res[index3] * 3 ){
                index3++;
            }
            if( min == res[index5] * 5 ){
                index5++;
            }
            res[i] = min;
            i++;
        }
        return res[n];

    }

}
