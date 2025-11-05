package com.maji.maojianwei.leetcode.algrithm;
/*一共有1，5，10，20，50，100面值的货币，n元有多少种组合方式！！*/
import java.util.*;
public class ChangeMoney {
	public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n =in.nextInt();
        int[] coins = {1,5,10,20,50,100};
        long[][] c = new long[6][n+1];
        Arrays.fill(c[0],1);//只使用1，只有一种组合即全是1；
        for(int i =0;i<6;i++){
            c[i][0] = 0;
            c[i][1] = 1;
        }
        for(int i =1;i<6;i++){//逐次增加更大面值的硬币
            for(int j=2;j<=n;j++){//从1-n的情况都要考虑；
                if(j <coins[i]){//如果小于面值，则和没有这个是一样的；
                    c[i][j] = c[i-1][j];
                }
                else if(j == coins[i]){//如果等于，多一种
                    c[i][j] = c[i-1][j]+1;
                }
                else{//如果是买年至的很多倍，则依然采用递归的结构！
                    c[i][j] = c[i-1][j]+c[i][j-coins[i]];
                }
            }
        }
        System.out.println(c[5][n]);
        for(int i=0;i<=n;i++) {
        	System.out.print("----");
        }
        System.out.println();
        System.out.printf("%4s","   |");
        for(int i =0;i<=n;i++) {
        	System.out.printf("%4d",c[0][i]);
        }
        System.out.println();
        for(int i =1;i<6;i++) {
        	System.out.printf("%3d%c", i,'|');
        	for(int j =0;j<=n;j++) {
        		System.out.printf("%4d",c[i][j]);
        	}
        	System.out.println();
        }
        
	}
}
