package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/8 , 21:00
 */
public class SynchronizedStateDemo {

    public static void main(String[] args){
        ThreadDemo10 thread1 = new ThreadDemo10(1);
        ThreadDemo10 thread2 = new ThreadDemo10(2);
        thread1.start();
        thread2.start();
    }
}
class CountDemo2{
    public static int i = 0 ;
    public static int getCount(){
        Object o = new Object();
        System.out.println("thread"+ Thread.currentThread().getId()+ " state :" + Thread.currentThread().getState());
        synchronized (o){
            System.out.println("thread"+ Thread.currentThread().getId()+ " state :" + Thread.currentThread().getState());
            i++;
        }
        System.out.println("thread"+ Thread.currentThread().getId()+ " state :" + Thread.currentThread().getState());
        return i;
    }

}

class ThreadDemo10 extends Thread{
    public int index;
    public ThreadDemo10(int k){
        index = k;
    }
    public int getIndex(){
        return  index;
    }
    @Override
    public void run(){
        for( int i = 0 ;i < 10 ; i++){
            System.out.println("thread"+ index + " state :" + Thread.currentThread().getState());
            System.out.println("thread"+ index + " state :" + CountDemo2.getCount());
            System.out.println("thread"+ index + " state :" + Thread.currentThread().getState());
        }

    }

}
