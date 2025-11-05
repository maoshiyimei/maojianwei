package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: sleep 方法不会释放锁: 进入 time_waiting状态
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:12
 */
public class ThreadDemo_Sleep {

    public synchronized void method() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println( Thread.currentThread().getName() + " " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadDemo_Sleep test = new ThreadDemo_Sleep();
        List<Thread> threads = new ArrayList<>();
        for( int i = 0 ;i < 100; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.method();
                }
            });
            threads.add(thread);
            thread.start();
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
