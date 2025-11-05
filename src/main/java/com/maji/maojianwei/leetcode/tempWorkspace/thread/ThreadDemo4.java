package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:24
 */
public class ThreadDemo4 {
    /* 同步方法 */
    public synchronized void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodA-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /* 同步代码块  this */
    public void methodB() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodB-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /* 同步代码块 对象 this锁不是同一个，可以并发执行*/
    public void methodC() {
        Object obj = new Object();
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodC-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo4 test3 = new ThreadDemo4();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodA();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodB();
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                test3.methodC();
            }
        });
        thread3.start();

    }
}
