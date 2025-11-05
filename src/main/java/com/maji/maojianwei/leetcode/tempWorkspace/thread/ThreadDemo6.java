package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:41
 */
public class ThreadDemo6 {

    /*对象锁*/
    public synchronized  void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodA-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /*类锁*/
    public synchronized static void methodB() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodB-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadDemo6 test5 = new ThreadDemo6();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test5.methodA();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test5.methodB();
            }
        });
        thread2.start();
    }
}
