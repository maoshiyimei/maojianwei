package com.maji.maojianwei.leetcode.tempWorkspace.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 18:48
 */
public class ThreadDemo1{
    private int j=0;
    public static void main(String args[]){
        ThreadDemo1 tt=new ThreadDemo1();
        Inc inc=tt.new Inc();
        Dec dec=tt.new Dec();
        for(int i=0;i<2;i++){
            Thread t=new Thread(inc);
            t.start();
            t=new Thread(dec);
            t.start();
        }
    }
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-dec:"+j);
    }
    class Inc implements Runnable{
        public void run(){
            for(int i=0;i<100;i++){
                inc();
            }
        }
    }
    class Dec implements Runnable{
        public void run(){
            for(int i=0;i<100;i++){
                dec();
            }
        }
    }
}
