package com.maji.maojianwei.leetcode.ds_type.dataStruct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 */
public class QueueToStack {

    /**
     * 一个栈中保存最后一个元素，这样pop()返回这个元素就是最新的元素，两个队列轮换作为push()进入
     */

    public static Queue<Integer> queue1 = new LinkedList<>();
    public static Queue<Integer> queue2 = new LinkedList<>();

    public static void push(int num){
        queue1.offer(num);
    }

    public static int pop(){
        if(queue1.isEmpty()){
            return -1;
        }
        while(queue1.size() != 1){
            queue2.offer(queue1.poll());
        }
        int num = queue1.poll();
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
        return num;
    }

    public static void main(String[] args){
        QueueToStack.push(1);
        QueueToStack.push(2);
        QueueToStack.push(3);
        QueueToStack.push(4);
        System.out.println(QueueToStack.pop());
        QueueToStack.push(5);
        System.out.println(QueueToStack.pop());
        QueueToStack.push(6);
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
        System.out.println(QueueToStack.pop());
    }
}
