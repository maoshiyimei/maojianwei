package com.maji.maojianwei.leetcode.java_language.test.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemoWIthOptLock {
    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                   num.incrementAndGet();
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
