package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDemo_PrintSeparate {

    public static boolean oddHasPrint;
    private static int i = 0;
    private static Object lock = new Object();
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new PrintOddTask());
        executorService.execute(new PrintEvenTask());
        executorService.shutdown();

    }

    static  class PrintOddTask implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (!oddHasPrint) {
                        i++;
                        oddHasPrint = true;
                        System.out.println(Thread.currentThread().getName() + " print : " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
    }

    static  class PrintEvenTask implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if (oddHasPrint) {
                        i++;
                        oddHasPrint = false;
                        System.out.println(Thread.currentThread().getName() + " print : " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
    }
}
