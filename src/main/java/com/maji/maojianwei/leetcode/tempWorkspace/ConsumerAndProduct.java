package com.maji.maojianwei.leetcode.tempWorkspace;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/20 , 16:35
 */
public class ConsumerAndProduct {
    private static boolean isExist = false;
    public static void main ( String[] args){
        ExecutorService executor  = Executors.newFixedThreadPool(4);
        for ( int i = 0 ; i< 2 ; i++){
            executor.execute(new ProducerTask());
            executor.execute(new ConsumerTask());
        }
        executor.shutdown();

    }
    private static class ProducerTask implements Runnable{
        public void run() {
            try {
                while(true) {
                     Product.produce();
                    Thread.sleep(1000);//���ߵ������ǲ�Ҫ̫�죬��Ӱ���̻߳��������
                }
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static class ConsumerTask implements Runnable{
        public void run() {
            try {
                while(true) {
                    Product.consume();
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static class Product{
        private static boolean isExist = false;
        private static Lock lock =new ReentrantLock();
        private static Condition canConsumer = lock.newCondition();
        private static Condition canProduct = lock.newCondition();

        public static void consume(){
            lock.lock();
            try{
                while(!isExist){
                    canConsumer.await(); // �ȴ�
                }
                System.out.println( Thread.currentThread().getId() + " Consume...");
                isExist = false; // ����
                canProduct.signal();
            }
            catch(InterruptedException ex) {ex.printStackTrace();}
            finally {
                lock.unlock();
            }

        }
        public static void produce(){
            lock.lock();
            try{
                while(isExist){
                    canProduct.await(); // �ȴ�
                }
                System.out.println( Thread.currentThread().getId() + " Procuce...");
                isExist = true; // ����
                canConsumer.signal();
            }
            catch(InterruptedException ex) {ex.printStackTrace();}
            finally {
                lock.unlock();
            }

        }
    }
}
