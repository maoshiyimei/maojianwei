package com.maji.maojianwei.leetcode.java_language.thread;

/**
 * Class: 演示说明 synchronized也是可重入锁，否则会死锁！
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/13 , 20:02
 */
public class ReEntrantlockDemo1 {

    public static void main(String[] args){
        for(int i = 0 ;i < 10; i++){
            Thread mythread = new MyThreaddemo();
            mythread.start();
        }
    }
}

class Taskdemo{
    public synchronized void makeFish() throws InterruptedException {
        System.out.println( Thread.currentThread().getId() + " plan to make fish:");
        fishing();
        System.out.println(Thread.currentThread().getId() + " cooking fish...");
    }

    public synchronized void fishing() throws InterruptedException {
        System.out.println( Thread.currentThread().getId() +  " fishing...");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getId() + " got one!");
    }
}

class  MyThreaddemo extends Thread{
    @Override
    public void run(){
        Taskdemo task = new Taskdemo();
        try {
            task.makeFish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
