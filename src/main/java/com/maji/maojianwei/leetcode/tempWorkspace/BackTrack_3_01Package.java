package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: 01�������⣬n=3, w=(16,15,15), v=(45,25,25), c=30
 * ���ݷ��õ��������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/21 , 12:43
 */
public class BackTrack_3_01Package {
    public static int n = 3;
    public static int[] w = {16,15,15};
    public static int[] v = {45,25,25};
    public static final int c = 30;
    /* ��ռ� */
    public static int bestV = 0;
    public static int cw = 0;
    public static int cv = 0;

    public static void main(String[] args){
        getMaxValue(0);
        System.out.println("best value: "+ bestV);
    }
    public static void getMaxValue(int i){
        if( i == n){
            System.out.println("currnet bestV:"+ bestV);
            bestV = bestV > cv ? bestV : cv;
        }
        else{
            if( cw + w[i] <= c ){
                cw += w[i];
                cv += v[i];
                getMaxValue(i+1);
                cw -= w[i];
                cv -= v[i];
            }
            getMaxValue( i + 1);

        }

    }

}
