package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
	private static AtomicInteger num = new AtomicInteger(0);
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch count = new CountDownLatch(30);
		
		for(int i =0;i<30;i++) {
			new Thread() {
				@Override
				public void run() {
					for(int j =0;j<100000;j++)
						num.incrementAndGet();
					count.countDown();
				}
			}.start();
		}
		
		count.await();
		System.out.println(num);

	}

}
