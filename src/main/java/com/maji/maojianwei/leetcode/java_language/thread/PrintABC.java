package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.locks.LockSupport;

public class PrintABC {

    private static Thread t1,t2,t3;
    /**
     * 使用 park unpark(),唤醒指定顺序的线程
     * @param args
     */
    public static void main(String[] args){
        


        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10; i++){
                    LockSupport.park();
                    System.out.println("A");
                    LockSupport.unpark(t2);
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10; i++){
                    LockSupport.park();
                    System.out.println("B");
                    LockSupport.unpark(t3);
                }
            }
        });


        t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10; i++){
                    // 先唤醒1然后阻塞，当被2唤醒后才能答应C
                    LockSupport.unpark(t1);
                    LockSupport.park();
                    System.out.println("C");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
