package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.LinkedList;

public class ProducerAndConsumerDemo_WAIT_NOTIFY {
    public static void main(String[] args){
        // 仓库对象
        AbstractStorage abstractStorage = new Storage();

        // 生产者对象
        Producer p1 = new Producer(abstractStorage);
        Producer p2 = new Producer(abstractStorage);
        Producer p3 = new Producer(abstractStorage);
        Producer p4 = new Producer(abstractStorage);
        Producer p5 = new Producer(abstractStorage);
        Producer p6 = new Producer(abstractStorage);
        Producer p7 = new Producer(abstractStorage);

        // 消费者对象
        Consumer c1 = new Consumer(abstractStorage);
        Consumer c2 = new Consumer(abstractStorage);
        Consumer c3 = new Consumer(abstractStorage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }

}

class Storage implements AbstractStorage{
    private final int MAX_SIZE = 100;
    private LinkedList list = new LinkedList();


    public void produce(int num){
        synchronized (list){
            while(list.size() + num > MAX_SIZE){
                System.out.println("[ to produce ]:" + num + "\t [capacity]:" + list.size() + "\t can not produce now!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++){
                list.offer(new Object());
            }
            System.out.println("[ produced done ]" + num + "\t[capacity]:" + list.size());
            list.notifyAll();
        }
    }

    public void consume(int num){
        synchronized (list){
            while(num > list.size()){
                System.out.println("[to consume]:" + num + "\t[capacity]:" + list.size() + "\tcan not consume now!!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++){
                list.poll();
            }
            System.out.println("[ consumed done]:" + num + "\t[capacity]:" + list.size());
            list.notifyAll();
        }
    }

}

interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}

class Producer extends Thread{
    //每次生产的数量
    private int num ;
    //所属的仓库
    public AbstractStorage abstractStorage;
    public Producer(AbstractStorage abstractStorage){
        this.abstractStorage = abstractStorage;
    }
    public void setNum(int num){
        this.num = num;
    }
    // 线程run函数
    @Override
    public void run()
    {
        produce(num);
    }
    // 调用仓库Storage的生产函数
    public void produce(int num)
    {
        abstractStorage.produce(num);
    }
}

class Consumer extends Thread{
    private int num;
    public AbstractStorage abstractStorage;
    public Consumer(AbstractStorage abstractStorage){
        this.abstractStorage = abstractStorage;
    }
    public void setNum(int num){
        this.num = num;
    }
    @Override
    public void run() {
        consume(num);
    }
    public void consume(int num){
        this.abstractStorage.consume(num);
    }
}

