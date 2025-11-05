package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo_PrintSeparate_byLock {

    private static int i = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition oddHasPrint = lock.newCondition();
    private static Condition evenHasPrint= lock.newCondition();


    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new PrintOddTask());
        executorService.execute(new PrintEvenTask());
        executorService.shutdown();

    }

    static  class PrintOddTask implements Runnable{
        @Override
        public void run() {
            while(true) {
                lock.lock();
                try{
                    while( i %2 == 0 ){
                        evenHasPrint.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " print: " + i);
                    i++;
                    Thread.sleep(500);
                    oddHasPrint.signal();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static  class PrintEvenTask implements Runnable{
        @Override
        public void run() {
            while(true) {
                lock.lock();
                try {
                    while(i%2 == 1){
                        oddHasPrint.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " print: " + i);
                    i++;
                    Thread.sleep(500);
                    evenHasPrint.signal();
                }
                catch (InterruptedException i){
                    i.printStackTrace();
                }
                finally{
                    lock.unlock();
                }
            }
        }
    }
}
