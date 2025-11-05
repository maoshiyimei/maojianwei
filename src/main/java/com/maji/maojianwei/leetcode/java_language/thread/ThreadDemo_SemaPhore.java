package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.Semaphore;

/**
 * 两个线程交替打印1-100
 */
public class ThreadDemo_SemaPhore {
    int i =1;
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);// 只可能交替执行。

    public static void main(String[] args) {
        ThreadDemo_SemaPhore t = new ThreadDemo_SemaPhore();
        t.print();
    }
    void print(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while(i<=100) {
                    try {
                        s1.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i++);
                    s2.release();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(i<=100) {
                    try {
                        s2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i++);
                    s1.release();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
