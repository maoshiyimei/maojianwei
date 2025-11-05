package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: ����һ�� 2*N �ľ��εذ壬Ȼ��ʹ�� 1*2�ķ�������䣬�����ܹ��ж����ַ�����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/11 , 11:53
 */
public class Matrix_3_FillGround {
    public static void main(String[] args ){
        int n = 6;
        System.out.println( fillGrand( n ));
        List<Integer> list = new ArrayList<>();
    }
    /* ʹ�ü򵥵ĵݹ��㷨��������Ҫ�� */
    public static int fillGrand(int n ){
        if( n == 1 || n == 0 ){
            return 1;
        }
        else{
            return fillGrand( n -1 ) + fillGrand( n -2);
        }

    }

}
