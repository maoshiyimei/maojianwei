package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Scanner;

/**
 * Class:��һ���˿��ƣ�ÿ���ƽ���1��10֮��
 * �����ֳ��Ʒ�����
 * ����1��
 * ��2�Ŷ���
 * ������˳�ӣ���12345
 * ���������ӣ���112233
 * ��10��������ʾ1-10ÿ�����м��ţ�������Ҫ���ٴ��ܳ���
 *
 * ����
 * 1 2 2 2 3 1 1 1 2 1 - > 6
 * 0 2 2 2 1 1 1 1 0 1 -> 5
 *
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/20 , 16:30
 */
public class DFS_3_CardGame {
    public static int turns = Integer.MAX_VALUE;
    public static int N = 10;
    public static int[] card = new int[N];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] array = new int[N+1];
        array[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            int number = in.nextInt();
            array[i] = number;
            card[i] = number;
        }

        System.out.println("mathod 1 : " + getMinTurns(array));
        //getMinTurns2();
        System.out.println("mathod 2 : " + turns );
    }
/*�÷�������ȷ��̰���㷨��ʵ����ĳЩ����°��̶�˳�������ƻ������������*/
    public static int getMinTurns(int[] array){
        int count = 0;
        while(!isFinished(array)){
            if(removeThreePairs(array)){
                count++;
                continue;
            }
            if(removeFive(array)){
                count++;
                continue;
            }
            if(removePair(array)){
                count++;
                continue;
            }
            removeSingle(array);
            count++;
        }
        return count;

    }
    public static boolean removePair(int[] array){
        for(int i = 1 ;i <= 10 ; i++ ){
            if(array[i]>=2){
                array[i] -=2;
                return true;
            }
        }
        return false;
    }
    public static boolean removeSingle(int[] array){
        for(int i = 1 ;i <= 10 ; i++ ){
            if(array[i]>=1){
                array[i] -=1;
                return true;
            }
        }
        return false;
    }
    public static boolean removeThreePairs(int[] array){
        int flag = 0;
        int count = 0;
        for(int i = 1 ;i <= 10 ; i++ ){

            if(array[i]>=2){
                if(flag == 0) {
                    flag = 1;
                }
                count++;
                if(count==3){
                    array[i] -= 2;
                    array[i-1] -= 2;
                    array[i-2] -= 2;
                    return true;
                }
            }
            else{
                count=0;
                flag = 0;
            }
        }
        return false;

    }
    public static boolean removeFive(int[] array){
        int flag = 0;
        int count = 0;
        for(int i = 1 ;i <= 10 ; i++ ){

            if(array[i]>=1){
                if(flag == 0) {
                    flag = 1;
                }
                count++;
                if(count==5){
                    array[i] -= 1;
                    array[i-1] -= 1;
                    array[i-2] -= 1;
                    array[i-3] -= 1;
                    array[i-4] -= 1;
                    return true;
                }
            }
            else{
                count=0;
                flag = 0;
            }
        }
        return false;

    }
    public static boolean isFinished(int[] array){
        for(int i = 0 ; i<= 10 ;i ++){
            if(array[i] != 0) {
                return false;
            }
        }
        return true;
    }

//    public static void getMinTurns2(){
//        if(isFinished()){
//            return ;
//        }
//    }

}
