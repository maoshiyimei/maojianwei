package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo_PrintSeparate_bylock_2 {
    int i =1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    boolean firstDone = false;
    public static void main(String[] args) {
        ThreadDemo_PrintSeparate_bylock_2 t = new ThreadDemo_PrintSeparate_bylock_2();
        t.print();
    }
    void print(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    lock.lock();
                    if(!firstDone) {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(i);
                        i++;
                        firstDone = true;
                        condition2.signal();
                    }
                    else {
                        try {
                            condition1.await();  //等待条件的时候，会自动释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (i <= 100) {
                    lock.lock();
                    if(firstDone) {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(i);
                        i++;
                        firstDone = false;
                        condition1.signal();
                    }
                    else {
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
