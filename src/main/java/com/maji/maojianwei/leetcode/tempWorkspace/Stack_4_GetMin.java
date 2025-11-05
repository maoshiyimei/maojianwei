package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.List;
import java.util.Stack;

/**
 * Class:��õ�ǰջ��������СԪ�ص�min�� O��1�� ��ջ�Ĳ�������Ӱ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/6 , 22:49
 */
public class Stack_4_GetMin {

    public static Stack<Integer> dataStack = new Stack<>();
    public static Stack<Integer> minStack  = new Stack();

    public static void printStack(Stack<Integer> stack){
        Integer[] array  = new Integer[stack.size()];
        stack.toArray(array);
        System.out.print("stack number ��");
        for(Integer i : array){
            System.out.print(i+ " ");
        }
        System.out.println();
    }
    public static void push(int data){
        dataStack.push(data);
        if( minStack.isEmpty() || minStack.peek() >= data){
            minStack.push(data);
        }
    }
    public static int pop(){
        int data = dataStack.pop();
        if(data == minStack.peek()){
            minStack.pop();
        }
        return data;
    }
    public static int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        for(int i = 0;i< 15 ; i++){
            push((int)(Math.random()*100) );
            printStack(dataStack);
            System.out.println("min in stack :"+ getMin());
        }
        for(int i = 0;i< 10 ; i++){
            pop();
            printStack(dataStack);
            System.out.println("min in stack :"+ getMin());
        }


    }



}
