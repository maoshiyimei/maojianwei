package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutorDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(new MyThread2());
		pool.execute(new MyThread2());
		pool.execute(new MyThread2());
		pool.execute(new MyThread2());
		pool.execute(new MyThread2());
		pool.isShutdown();

	}

}
class MyThread2 extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getId()+ "run:");
		int count = 0;
		for(int i= 0;i<1000;i++) {
			count++;
		}
	}
}
