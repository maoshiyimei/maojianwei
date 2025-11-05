package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CatchedThreadPoolDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.execute(new MyThread3());
		pool.isShutdown();
	}
}

class MyThread3 extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getId()+ "run:");
		int count = 0;
		for(int i= 0;i<1000;i++) {
			count++;
		}
	}
}
