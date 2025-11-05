package com.maji.maojianwei.leetcode.java_language.thread;

public class ThreadDemo_WAIT_NOTIFY {
    // 创建一个将被两个线程同时访问的共享对象
    public static Object object = new Object();

    // Thread0线程，执行wait()方法
    static class Thread0 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "get lock first time");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "get loc again ");
            }
        }

    }

    // Thread1线程，执行notify()方法
    static class Thread1 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + "get lock ");
            }
        }
    }

    // 主线程
    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread1 thread1 = new Thread1();
        thread0.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.start();
    }

}
