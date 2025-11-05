package com.maji.maojianwei.leetcode.java_language.thread;

public class ThreadDemo_PrintSeparate_2 {
    int i =1;
    boolean firstDone = false;  // 打印奇数的线程是否已经打印过了，这是同步的关键，借助了object 的的wait()方法和notify（）
    Object lock = new Object();
    public static void main(String[] args) {
        ThreadDemo_PrintSeparate_2 t = new ThreadDemo_PrintSeparate_2();
        t.print();
    }
    void print() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (; i <= 100; ) {
                    synchronized (lock) {
                        if (!firstDone) {
                            System.out.println(Thread.currentThread().getName());
                            System.out.println(i++);
                            firstDone = true;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (; i <= 100; ) {
                    synchronized (lock) {
                        if (firstDone) {
                            System.out.println(Thread.currentThread().getName());
                            System.out.println(i++);
                            firstDone = false;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
