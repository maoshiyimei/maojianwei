package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class: LRU ��ʾ�� read�еķ������ݿ�ţ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/3 , 13:49
 */
public class Queue_3_LRU {
    public static void main(String[] args){
        int[] read = {1,2,3,4,3,2,3,4,6,5,2,1,3,5,6,4,5,3,2,3,4,5,6,6,7,7,2,2,3,4,5,4,3,2,1};
        doWork(read, 4);
    }
    public static void doWork(int[] task, int k){
        int n  = task.length;
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0 ; i < n ;i++){
            if( queue.contains(task[i])){
                Integer[] list = new Integer[queue.size()];
                queue.toArray(list);
                for( int j = 0 ; j < queue.size() ; j++){
                    if(list[j] == task[i]){
                        for(int m = j; m < queue.size()-1 ; m++){
                            list[m] = list[m+1];
                        }
                        list[queue.size()-1] = task[i];
                        break;
                    }
                }
                queue.clear();
                queue = new LinkedList<Integer>(Arrays.asList(list));
            }
            else if(queue.size() == k){
                queue.poll();
                queue.offer(task[i]);
            }
            else{
                queue.offer(task[i]);
            }
            System.out.print(task[i] + " -> ");
            print(queue);
        }

    }

    public static void print(Queue<Integer> queue){
        System.out.print("[ ");
        Integer[] list = new Integer[queue.size()];
        queue.toArray(list);
        for( int i = 0 ; i< queue.size() ;i ++){
            System.out.print(list[i].toString() + " ");
        }
        System.out.println("]");
    }
}
