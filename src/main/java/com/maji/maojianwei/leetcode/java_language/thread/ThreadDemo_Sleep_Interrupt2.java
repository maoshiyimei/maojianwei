package com.maji.maojianwei.leetcode.java_language.thread;

/**
 * Class: sleep 方法不会释放锁, 如果被中断则响应中断, 然后会继续执行直到线程完成！
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/1 , 19:12
 */
public class ThreadDemo_Sleep_Interrupt2 {

    public synchronized void method() {
        for (int i = 0; i < 100; i++) {
            System.out.println( Thread.currentThread().getName() + " status= " + Thread.currentThread().getState() + "  "+ i);
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "  interrupted, status= " + Thread.currentThread().getState());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo_Sleep_Interrupt2 test = new ThreadDemo_Sleep_Interrupt2();

        for( int i = 0 ;i < 10; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.method();
                }
            });
            thread.start();
            thread.interrupt();
            Thread.sleep(3000);
            thread.interrupt();
        }

    }
}
