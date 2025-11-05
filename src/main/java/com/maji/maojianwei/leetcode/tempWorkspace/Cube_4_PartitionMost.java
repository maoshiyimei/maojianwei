package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: 一个长方体长宽高分别是 xyz,切k刀，问最多切成几块
 * 如 2 2 2 3 - > 8
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/24 , 16:36
 */
public class Cube_4_PartitionMost {
    public static int[] params = {2,2,2,3};
    public static void main(String[] args){
        System.out.println( getCutNumber(params[0],params[1],params[2],params[3]));
    }
    public static long getCutNumber(int x ,int y ,int z, int k ) {
        long sum = 1 ;
        int remainX = x-1, lineX = 1;
        int remainY = y-1, lineY = 1;
        int remainZ = z-1, lineZ = 1;
        while( k!=0 &&  (remainX!=0 || remainY !=0 ||remainZ!=0 )){
            int[] mult  = new int[3];
            mult[0] = remainX > 0 ? (lineY*lineZ) : 0 ;
            mult[1] = remainY > 0 ? (lineZ*lineX) : 0 ;
            mult[2] = remainZ > 0 ? (lineX*lineY) : 0 ;
            int maxMult = mult[0];
            int maxIndex = 0;
            for(int i = 1; i < 3 ; i++){
                if(mult[i] > maxMult){
                    maxIndex = i;
                    maxMult = mult[i];
                }
            }

            if(maxIndex == 0 ){
                remainX--;
                lineX++;
                sum +=  mult[0];
            }
            else if(maxIndex == 1){
                remainY--;
                lineY++;
                sum +=  mult[1];
            }
            else{
                remainZ--;
                lineZ++;
                sum +=  mult[2];
            }
            k--;
        }
        return sum;
    }

}
