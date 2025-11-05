package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:12
 */
public class ThreadDemo2 {

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
    /* 线程获得同步方法锁后， 其它线程依然可以自由调用非同步方法*/
    public void methodB() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodB-" + i );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThreadDemo2 test = new ThreadDemo2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.methodA();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.methodB();
            }
        });
        thread2.start();
    }
}
