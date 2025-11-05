package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class: ��XԪ����ʹ���Ż�ȯ����n�Ӳˣ�ÿ�ּ۸�̶�ֻѡһ�Σ����ٻ�����Ԫ�������Ż�ȯ
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/2 , 23:02
 */
public class Package_3_MinCostToUseCoupon {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int x = in.nextInt();
        int[] price = new int[n];
        for(int i = 0;i<n;i++){
            price[i] = in.nextInt();
        }
        System.out.println(calculateMinCost(price , x) );
    }

    public static int calculateMinCost(int[] price, int floor ){

        return 0;
    }
}
