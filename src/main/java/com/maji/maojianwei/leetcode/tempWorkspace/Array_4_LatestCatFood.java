package com.maji.maojianwei.leetcode.tempWorkspace; /**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/19 , 20:18
 */
import java.util.*;

public class Array_4_LatestCatFood{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int time = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        String[] array = s.split("\\s+");
        for(String subString : array){
            list.add( Integer.valueOf(subString));
        }
        System.out.println( solution( list, time) );
    }
    public static int solution(ArrayList<Integer> list, int time){
        int k = 0;
        int sum = 0;
        int n = list.size();
        for(int i = 0 ; i < n ;i++){
            sum += list.get(i);
        }
        k = sum/time;
        while(k<=sum){
            int hour = 0;
            for(int i = 0 ;i <n ;i++){
                hour+=(int)Math.ceil( list.get(i)*1.0/k );
            }
            if(hour>time){
                k++;
            }
            else{
                return k;
            }
        }
        return k;
    }
}
