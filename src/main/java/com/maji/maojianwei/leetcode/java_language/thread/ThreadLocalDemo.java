package com.maji.maojianwei.leetcode.java_language.thread;

public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(i)).start();
        }
    }

    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("thread " + index + " INIT value:" + value.get());
            for (int i = 1; i < index+1; i++) {
                value.set(value.get() + 1);
            }
            System.out.println("thread " + index + " ACC value:" + value.get());
        }
    }
}