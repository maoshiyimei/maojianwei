package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class: ����n��ѧ���Ľ�����Һ��߳����ҵ�ʱ�䣬ͳ�Ƹ���ʱ��ε�����
 * �� �� 10 30
 *       15 35
 *    -> 10-15 :1
 *    -> 15-30: 2
 *    -> 30-35: 1
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/11 , 11:03
 */
public class UnClassed_3_CountUpStudents {
    public static void main(String[] args){
        int[][] time = {
                {1, 20},
                {3, 9},
                {1, 15},
                {5, 18},
                {7, 15},
                {14,19},
                {10,20},
                {10,15},
                {8, 10},
                {3, 4},
                {1,11}
        };
        int[][] result = countOnStudentsInClassroom(time);
        for( int i = 0 ; i< result.length; i++){
            System.out.println( result[i][0] + " -> " + result[i][1] + " : " + result[i][2] + " people");
        }
    }
    public static int[][] countOnStudentsInClassroom(int[][] time){
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < time.length ; i++){
            set.add(time[i][0]);
            set.add(time[i][1]);
        }
        int[] timePoints = new int[set.size()];
        int k  = 0 ;
        Iterator<Integer> it = set.iterator();
        while( it.hasNext()){
            timePoints[k++] = it.next();
        }
        Arrays.sort( timePoints );
        int[] count = new int[timePoints.length];
        Arrays.fill( count , 0);
        for( int i = 0 ;i < time.length ; i++){
            for( int j = 1; j<timePoints.length ; j++ ){
                if( timePoints[j-1] >= time[i][0] && timePoints[j] <= time[i][1]){
                    count[j]++;
                }
            }
        }

        int[][] result = new int[timePoints.length-1][3];
        for( int i = 1, m = 0 ; i < timePoints.length ; i++, m++){
            result[m][0] = timePoints[i-1];
            result[m][1] = timePoints[i];
            result[m][2] = count[i];
        }
        return result;
    }
}
