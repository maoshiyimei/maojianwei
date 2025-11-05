package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: sleep 方法不会释放锁, 如果被中断则响应中断
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:12
 */
public class ThreadDemo_Sleep_Interrupt {

    public synchronized void method() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println( Thread.currentThread().getName() + " status= " + Thread.currentThread().getState() + "  "+ i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "  interrupted, status= " + Thread.currentThread().getState());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo_Sleep_Interrupt test = new ThreadDemo_Sleep_Interrupt();

        List<Thread> threads = new ArrayList<>();
        for( int i = 0 ;i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.method();
                }
            });
            threads.add(thread);
            printThreadStatus(threads);
            thread.start();
            printThreadStatus(threads);
            thread.interrupt();
            printThreadStatus(threads);
        }

    }

    public static void printThreadStatus(List<Thread> threads){
        for(Thread t : threads){
            System.out.print(t.getName()+ ": " + t.getState() + " ");
        }
        System.out.println();
    }
}
