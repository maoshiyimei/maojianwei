package com.maji.maojianwei.leetcode.java_language.thread;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:16
 */
public class ThreadDemo_Reentry_synchronized {

    /**
     * 可重入锁
     */
    public synchronized void method() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
      ThreadDemo_Reentry_synchronized test = new ThreadDemo_Reentry_synchronized();
      for( int i = 0 ; i< 10 ;i++){
          Thread thread = new Thread(new Runnable() {
              @Override
              public void run() {
                  test.method();
              }
          });
          thread.start();
      }
    }
}
