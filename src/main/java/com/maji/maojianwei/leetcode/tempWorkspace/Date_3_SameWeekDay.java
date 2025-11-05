package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class:С½ÿ��Ҫдһ�ݹ����ձ����ձ����⺬�����ڡ��������������ǰ���ձ�����֪�������ձ��������Ƿ�ͬΪ���ڼ���
 *
 * 2
 * 1970 1 2 2020 2 7
 * 2020 1 1 2020 1 2
 *
 * true
 * false
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/29 , 21:43
 */
public class Date_3_SameWeekDay {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i =0; i < n; i++){
            List<Integer> dateOne = new ArrayList<>(3);
            List<Integer> dateTwo = new ArrayList<>(3);
            dateOne.add(in.nextInt());
            dateOne.add(in.nextInt());
            dateOne.add(in.nextInt());
            dateTwo.add(in.nextInt());
            dateTwo.add(in.nextInt());
            dateTwo.add(in.nextInt());
            System.out.println(isSameWeekDay( dateOne, dateTwo));
        }
    }
    public static boolean isSameWeekDay(List<Integer> dateOne, List<Integer> dateTwo){

        int yearBase = dateOne.get(0)>dateTwo.get(0)?dateTwo.get(0):dateOne.get(0);
        int daysOne =calculateDays(dateOne.get(0), dateOne.get(1), dateOne.get(2), yearBase);
        int daysTwo =calculateDays(dateTwo.get(0), dateTwo.get(1), dateTwo.get(2), yearBase);
        int diffDays = Math.abs( daysOne - daysTwo ) ;
        if( diffDays%7 == 0){
            return true;
        }
        else{
            return false;
        }

    }
    public static int calculateDays(int year,int month, int day , int baseyear){
        int result = 0;
        for(int i =baseyear; i< year;i++){
            if(isLeapYear(i)){
                result+=366;
            }
            else{
                result+=365;
            }
        }
        for(int i = 1; i< month ;i++){
            result+= monthDays(i, year);
        }
        result+= day;
        return result;
    }
    public static boolean isLeapYear(int year){
        if((year%4 == 0 && year%100!=0 ) || (year%100 == 0 && year%400 ==0 ) ){
            return true;
        }
        else{
            return false;
        }
    }
    public static int monthDays(int m ,int y){
        if(m ==1 || m ==3 || m == 5 || m ==7 || m ==8 || m == 10 || m == 12){
            return 31;
        }
        if( m == 4 || m == 6 || m ==9 || m ==11  ){
            return 30;
        }
        if( m==2 && isLeapYear(y)){
            return 29;
        }
        else{
            return 28;
        }
    }
    
    



}

