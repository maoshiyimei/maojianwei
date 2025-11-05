package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: ��Ӷκͣ������ӶΣ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 12:09
 */
public class DP_3_MaxSubSum {
    private static int n =20;
    private static int leftFlag=0;//���ڱ��λ�ã�
    private static int rightFlag=0;

    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("maxSubSum: "+ maxSubSum(array));
        for(int i =0; i<n; i++) {
            if(i==leftFlag) {
                System.out.print("[ "+array[i]+"  ");
            }
            else if(i == rightFlag) {
                System.out.print(+array[i]+" ]  ");
            }
            else {
                System.out.print(array[i]+"  ");
            }
        }
    }

    /* ������� ʱ�临�Ӷ�Ϊ O( n^2 ) */
    public static int maxSubSum(int[] array) {
        int n =array.length;
        int sum =Integer.MIN_VALUE;
        for(int i =0; i< n ;i++) {
            int tempSum =0;
            for(int j =i;j < n ;j++) {
                tempSum += array[j];
                if(tempSum > sum) {
                    sum = tempSum;
                    leftFlag = i;
                    rightFlag =j;
                }
            }
        }
        return sum;
    }
}
