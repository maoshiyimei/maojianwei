package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Class: 示例 COUNTDOWNlatch
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/16 , 12:27
 */
public class CountDownLatchDemo {


    static final int COUNT = 40;
    static CountDownLatch cdl = new CountDownLatch(COUNT);

    public static void main(String[] args) throws Exception {
        new Thread(new Teacher(cdl)).start();
        Thread.sleep(5000);
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Student(i, cdl)).start();
        }

    }

    static class Teacher implements Runnable {

        CountDownLatch cdl;

        Teacher(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("老师发卷子。。。");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("老师收卷子。。。");
        }

    }

    static class Student implements Runnable {

        CountDownLatch cdl;
        int num;
        Student(int num, CountDownLatch cdl) {
            this.num = num;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("学生 " + num + " 写卷子。。。");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("学生 " + num + " 交卷子。。。");
            cdl.countDown();
        }

    }

}
