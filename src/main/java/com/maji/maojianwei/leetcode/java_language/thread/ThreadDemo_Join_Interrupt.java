package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo_Join_Interrupt {

    /**
     * 如果主线程中断最好向子线程传递中断状态
     * @param args
     */
    public static void main(String[] args) {
        // main thread
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // let mainThread interrupt
                    System.out.println("thread1 start and let mainThread interrupt ");
                    mainThread.interrupt();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("thread1 end task");
                } catch (InterruptedException e) {
                    System.out.println("thread1 response to interrupt");
                    e.printStackTrace();
                }
            }
        }, "thread1");
        thread1.start();
        try {
            // 主线程在等待子线程执行结束后，再执行后续代码。如果主线程在等待时被打断，那thread1.join()会抛出异常，
            // 此时正确的做法是在catch语句中将中断传递给thread1,让thread1也中断，保证多个线程执行的一致性；
            // 若不手动终止thread1，则thread1会继续执行，可能会造成一些数据同步上的问题。
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(" mainF thread has interrupt: " + Thread.currentThread().getName());
            thread1.interrupt();
        }
        System.out.println("main thread end");
    }

}
