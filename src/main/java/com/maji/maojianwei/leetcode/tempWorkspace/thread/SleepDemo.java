package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class SleepDemo {

	public static void main(String[] args) {
		Runnable task1 = new PrintChar('a',40);
		Runnable task2 = new PrintChar('b',40);
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		thread1.start();
		thread2.start();
		
	}

}

