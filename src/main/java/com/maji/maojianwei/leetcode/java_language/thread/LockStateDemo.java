package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/8 , 21:00
 */
public class LockStateDemo {

    public static void main(String[] args){
        ThreadDemo thread1 = new ThreadDemo(1);
        ThreadDemo thread2 = new ThreadDemo(2);
        thread1.start();
        thread2.start();
    }
}

class CountDemo{
    public static int i = 0 ;
    public static int getCount() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock .lock();
        Thread.sleep(10000);
        lock.unlock();
        return i;
    }

}

class ThreadDemo extends Thread{
    public int index;
    public ThreadDemo(int k){
        index = k;
    }
    public int getIndex(){
        return  index;
    }
    @Override
    public void run(){
        for( int i = 0 ;i < 10 ; i++){
            System.out.println("thread"+ index + " start:" + Thread.currentThread().getState());
            try {
                System.out.println("thread"+ index + " state :" + CountDemo.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread"+ index + " end :" + Thread.currentThread().getState());
        }

    }

}
