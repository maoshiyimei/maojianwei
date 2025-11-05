package com.maji.maojianwei.leetcode.format.dp;

/**
 * 有一对兔子，从出生后第3个月起每一个月都生一对兔子，
 * 小兔子长到第三个月后每一个月又生一对兔子，假如兔子都不死，问每一个月的兔子总数为多少？
 */
public class RabbitNum {
    /**
     * 规律： 1 1 2 3 5 8 13 ... 斐波那契数列
     * 证明：
     * 兔子总对数 = 成年兔子对数 + 幼年兔子对数
     * 成年兔子对数 = 前月成年兔子对数+前月幼年兔子对数 = 前月总对数
     * 幼年兔子对数 = 前月成年兔子对数 = 大前月兔子总对数（由上条公式获得）
     * 兔子总对数 = 前月兔子总对数+大前月兔子总对数
     *
     * 兔子
     */

    public static int rabbitNum(int n){
        if( n== 1 || n == 2){
            return 1*2;
        }
        int pre = 1;
        int cur = 1;
        for( int i = 3; i<=n; i++){
            int temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur*2;
    }
}
