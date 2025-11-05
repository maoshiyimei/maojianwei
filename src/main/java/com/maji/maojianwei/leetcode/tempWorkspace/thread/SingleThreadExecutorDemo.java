package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.execute(new MyThread());
		pool.isShutdown();
	}

}
 class MyThread extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getId()+ "run");
	}
}
