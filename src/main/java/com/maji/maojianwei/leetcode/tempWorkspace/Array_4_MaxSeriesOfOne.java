package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Class:����һ��01�ַ����������=�ô����������1�ĳ��ȣ�������������K�λ��ᣬÿ�λ�����Խ����е�ĳ��0�ĳ�1
 * 10 2
 * 1 0 0 1 0 1 0 1 0 1 - > 5
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 22:14
 */
public class Array_4_MaxSeriesOfOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int array[] = new int[n];
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
        }
        System.out.println( solutionOne(array, k) );
    }
    /* һ��ѭ��
    * ˼·�� ���ȸı�һ���������ģ�������Ӵ�Ϊ6��k=3����һ���������������õ��������Ķ���
    *        ��Σ� ����һ�����У������б���Ķ���λ�ã����е�Ԫ�����Ϊ k ,������û����ʱ��
    *         ���θĳ�1����ӣ�����Ѿ������ˣ����滻����Ķ���λ�ã� �м���Ҫ��¼�����ֵ��
    * */
    public static int solutionOne(int[] array, int k ){
        int n = array.length;
        int count = 0;
        int max = 0;
        Queue<Integer> positionQueue = new LinkedList<>();
        for(int i = 0 ; i < n; i++ ){
            if( array[i]==1){
                count++;
            }
            else if(array[i]==0 && k > 0 ){
                positionQueue.offer(i);
                count++;
                k--;
            }
            else if( k == 0){
                positionQueue.offer(i);
                max = Math.max( max, count );
                count = i- positionQueue.poll();
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
