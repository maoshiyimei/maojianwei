package com.maji.maojianwei.leetcode.format.dp;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class CoverArea {

    /**
     * 递归算法：时间复杂度教较高
     * 每一次都判断剩下的是否>=两块
     */
    private static int count = 0;
    public static int rectCover(int target) {
        if(target <= 0){
            return 0;
        }
        cover(target, 1);
        return count;
    }
    public static void cover(int n , int i){
        if( i > n){
            count++;
            return;
        }
        cover(n ,i+1);
        if((n - i + 1 ) >= 2){
            cover(n, i+2);
        }
    }

    /**
     * 动态规划：实际上这也是个斐波那契数列的变形，
     */
    public static int rectCover2(int n) {
        if (n==0 || n==1 || n==2)
            return n;
        int a = 1, b = 2, c = 0;
        for (int i=3; i<=n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * n >= 1
     * @param n
     * @return
     */
    public static int getSolutions(int n ){
        int[] record = new int[n+1];
        record[0] = 1;
        record[1] = 1;
        for(int i = 2; i<= n ; i++){
            record[i] = record[i-1] + record[i-2];
        }
        return record[n];
    }


    public static int getSolutions2(int n ){
        int lastLast = 1;
        int last = 1;
        for(int i= 2; i<=n;i++){
            int temp = last;
            last = lastLast + last;
            lastLast = temp;
        }
        return last;
    }

}
