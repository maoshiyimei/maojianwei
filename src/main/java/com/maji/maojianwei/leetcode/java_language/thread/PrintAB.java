package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class PrintAB {

    public static Thread t1, t2;
    public static void main(String[] args){

        t1 = new Thread(()->{
            for(int i = 0; i< 1000; i++){
                LockSupport.park();
                System.out.println( " A: " +  i);
                LockSupport.unpark(t2);
            }
        });

        t2 = new Thread(()->{
            for(int i = 0; i< 1000; i++){
                LockSupport.unpark(t1);
                LockSupport.park();
                System.out.println( " B: " +  i);
            }
        });


        t1.start();
        t2.start();

    }

}
