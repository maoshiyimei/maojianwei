package com.maji.maojianwei.leetcode.java_language.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:38
 */
public class ThreadDemo_Class_Monitor {
    /* 类锁 */
    public synchronized static void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("methodA-" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   /* 类锁*/
    public void methodB() {
        synchronized (ThreadDemo_Class_Monitor.class) {
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

    public static void main(String[] args) {
        ThreadDemo_Class_Monitor test4 = new ThreadDemo_Class_Monitor();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test4.methodA();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test4.methodB();
            }
        });
        thread2.start();
    }
}
