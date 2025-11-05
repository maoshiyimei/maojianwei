package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExceptionTest {

	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new ReentrantLock();
//		lock.lock();
		Thread t1 =new Thread(new Runnable(){
			public void run() {
				try {
					lock.lockInterruptibly();
					//lock.lock();不会抛出异常会报错！
					System.out.println("得到锁！");
				}
				catch(InterruptedException e) {
					System.out.println("Interrupted");
				}
			}
		});
	
		t1.start();
		Thread.sleep(1);
		t1.interrupt();
		
	
	}

}
