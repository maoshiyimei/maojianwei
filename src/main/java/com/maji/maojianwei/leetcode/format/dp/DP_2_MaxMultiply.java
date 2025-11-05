package com.maji.maojianwei.leetcode.format.dp;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 13:32
 */
public class DP_2_MaxMultiply {
    public static void main(String[] args){
        int[] data = {1, -2, 4 , 5, -9, -2};

        System.out.println( maxMultiply( data ));

    }

    /**
     * 连续的乘机所以一次遍历即可
     * 因为符号的问题需要保留最大和最小值
     *
     * @param data
     * @return
     */
    public static int maxMultiply(int[] data){
        if(data == null || data.length <=1){
            return 0;
        }
        int n = data.length;
        int max = data[0];
        int min = data[0];
        for( int i = 1 ; i< n; i++){
            if(data[i] > 0 ){
                max = Math.max( data[i], data[i]*max);
                min = Math.min( data[i], data[i]*min);
            }
            else{
                int temp = data[i]*max;
                max = Math.max(temp, data[i]);
                max= Math.max(max, min*data[i]);
                min = Math.min(min*data[i], data[i]);
                min = Math.min(min, temp);
            }
        }
        return max ;
    }


}
