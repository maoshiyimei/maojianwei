package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class: 演示说明 synchronized也是可重入锁，否则会死锁！
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/13 , 20:02
 */
public class ReEntrantlockDemo1 {

    public static void main(String[] args){
            Thread mythread = new MyThreaddemo();
            mythread.start();
    }
}
class Taskdemo{
    public synchronized void makeFish() throws InterruptedException {
        System.out.println( " 准备做红烧鱼：");
        fishing();
        System.out.println("开始红烧鱼了。。。");
    }

    public synchronized void fishing() throws InterruptedException {
        System.out.println( " 钓鱼中...");
        Thread.sleep(5000);
        System.out.println("钓到了鱼！");
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
