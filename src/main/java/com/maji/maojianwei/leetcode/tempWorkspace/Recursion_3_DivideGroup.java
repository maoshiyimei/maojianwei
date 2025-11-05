package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: n��Ԫ�ػ��ֳ�k�ѣ����Ѳ�Ϊ�գ��Ҳ��ཻ����Ԫ�ز��ȣ����ж����ֻ��ַ���
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/20 , 22:03
 */
public class Recursion_3_DivideGroup {
    public static void main(String[] args){
        System.out.println( divideGroup(4, 3) );
    }
    /* ˼·�� ����ĳ��Ԫ��������Ҫô�䵥��һ�ѣ�Ҫô���ͱ��Ԫ����һ����ֻ�������������һ����Ϊ�ݹ�˼·�� ע��ݹ���� */
    public static int divideGroup(int n ,int k ){
        if( k > n || k == 0){
            return 0 ;
        }
        if(k == n || k == 1){
            return 1;
        }
        return divideGroup(n-1, k-1) + k*divideGroup(n-1, k);
    }



}
