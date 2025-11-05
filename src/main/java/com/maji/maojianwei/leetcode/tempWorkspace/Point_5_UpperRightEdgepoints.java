package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

/**
 * Class:P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。
 * 求出所有“最大的”点的集合。
 * example:
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 * 输出：
 * 4 6
 * 7 5
 * 9 0
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/6 , 18:15
 */
public class Point_5_UpperRightEdgepoints {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<Integer, Integer> points = new TreeMap<>(Comparator.reverseOrder());
        for(int i =0 ;i< n ;i++){
            points.put(input.nextInt(), input.nextInt());
        }
        Map<Integer, Integer> edgePoints = getEdgePoints2(points);
        for(Map.Entry<Integer,Integer> entry : edgePoints.entrySet() ){
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
    }
    /* 时间超限 */
    public static Map<Integer, Integer> getEdgePoints(Map<Integer, Integer> points ) {
        Map<Integer , Integer > nominatedPoints = new HashMap<>();
        for(Map.Entry<Integer, Integer> point : points.entrySet() ){
            int xValue = point.getKey();
            int yValue = point.getValue();
            Iterator<Map.Entry<Integer, Integer >> it = nominatedPoints.entrySet().iterator();
            while( it.hasNext() ){
                Map.Entry<Integer, Integer> nominatedPoint = it.next();
                if( nominatedPoint.getKey() < yValue ){
                    it.remove();
                }
            }
            nominatedPoints.put( yValue, xValue );
        }
        Map<Integer, Integer> edgePoints = new TreeMap<>();
        for(Map.Entry<Integer, Integer> point : nominatedPoints.entrySet() ){
            edgePoints.put( point.getValue(), point.getKey() );
        }
        return edgePoints;
    }
    /* 反过来逆序遍历，时间稍好, 但是依然超限*/
    public static Map<Integer, Integer> getEdgePoints2(Map<Integer, Integer> points ) {
        Map<Integer , Integer > nominatedPoints = new HashMap<>();
        for(Map.Entry<Integer, Integer> point : points.entrySet() ){
            int xValue = point.getKey();
            int yValue = point.getValue();
            Iterator<Map.Entry<Integer, Integer >> it = nominatedPoints.entrySet().iterator();
            int flag =0 ;
            while( it.hasNext() ){
                Map.Entry<Integer, Integer> nominatedPoint = it.next();
                if( nominatedPoint.getKey() > yValue ){
                    flag =1;
                    break;
                }
            }
            if(flag == 0){
                nominatedPoints.put( yValue, xValue );
            }
        }
        Map<Integer, Integer> edgePoints = new TreeMap<>();
        for(Map.Entry<Integer, Integer> point : nominatedPoints.entrySet() ){
            edgePoints.put( point.getValue(), point.getKey() );
        }
        return edgePoints;
    }


}
