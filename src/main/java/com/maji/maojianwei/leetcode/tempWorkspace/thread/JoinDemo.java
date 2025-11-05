package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class JoinDemo {

	public static void main(String[] args) {
		Runnable task1 = new PrintNum(1,100);
		Thread thread1 = new Thread(task1);
		thread1.start();
		

	}

}
