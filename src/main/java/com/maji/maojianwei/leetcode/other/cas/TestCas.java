package com.maji.maojianwei.leetcode.other.cas;

public class TestCas {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> {
            for(int i = 0 ; i< 100; i++){
                resource.increment();
                System.out.println("Thread 1 incremented count to " + resource.get());
            }

        });
        Thread t2 = new Thread(() -> {
            for(int i = 0 ; i< 100; i++){
                resource.increment();
                System.out.println("Thread 2 incremented count to " + resource.get());
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
