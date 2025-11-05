package com.maji.maojianwei.leetcode.java_language.java8;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    /**
     * 优先队列默认升序队列，小根堆
     * @param args
     */
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        priorityQueue.offer(3);
        priorityQueue.offer(10);
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println("peek:" + priorityQueue.peek());
        System.out.println("poll:" + priorityQueue.poll());
        for(int i : priorityQueue){
            System.out.println(i);
        }
    }
}
