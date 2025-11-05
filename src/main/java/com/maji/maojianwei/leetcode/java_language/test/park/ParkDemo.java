package com.maji.maojianwei.leetcode.java_language.test.park;

import java.util.concurrent.locks.LockSupport;

public class ParkDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("start.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("park....");
            LockSupport.park();
            System.out.println("resume.....");
        });
        thread.start();
        Thread.sleep(3000);
        System.out.println("unpark....");
        LockSupport.unpark(thread);
    }
}
