package com.maji.maojianwei.leetcode.java_language.thread;

public class PrintABC2 {

    public static final Object lockObj = new Object();
    public static int PrintStatus = 0;

    /**
     * 使用 synchronized + wait + notify完成线程之间的顺序指定
     * @param args
     */

    public static void main(String[] args ){

        Thread t1 = new Thread( () -> {
                    for(int i = 0 ; i < 10; i++){
                        synchronized (lockObj){
                            while(PrintStatus != 0 && PrintStatus != 3){
                                try{
                                    lockObj.wait();
                                }catch (InterruptedException e){
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println("A");
                            PrintStatus = 1;
                            lockObj.notifyAll();
                        }
                    }
                }
        );

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lockObj) {
                    while (PrintStatus != 1) {
                        try {
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    // 条件满足
                    System.out.println("B");
                    PrintStatus = 2;
                    lockObj.notifyAll();
                }
            }
        });

        Thread t3 = new Thread(()->{
            for(int i =0; i< 10; i++){
                synchronized (lockObj) {
                    while(PrintStatus !=2){
                        try{
                            lockObj.wait();
                        }catch (InterruptedException e){
                            throw new RuntimeException(e);
                        }
                    }

                    System.out.println("C");
                    PrintStatus = 3;
                    lockObj.notifyAll();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();

    }
}
