package com.maji.maojianwei.leetcode.java_language.test.atomic;

import java.util.concurrent.CountDownLatch;

public class AtomicDemoWIthLock {
    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    //非原子性，所以结果不是100*100
                    synchronized (AtomicDemo.class){
                        num++;
                    }
                }
                countDownLatch.countDown();
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        countDownLatch.await();
        System.out.println(num);

    }
}
