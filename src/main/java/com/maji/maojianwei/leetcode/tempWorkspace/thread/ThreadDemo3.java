package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:16
 */
public class ThreadDemo3{
    public void methodA() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("methodA-" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void methodB() {
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
      ThreadDemo3 test2 = new ThreadDemo3();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.methodA();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.methodB();
            }
        });
        thread2.start();
    }
}
