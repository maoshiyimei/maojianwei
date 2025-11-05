package com.maji.maojianwei.leetcode.java_language.thread;

public class ThreadDemo_Join {


	public static void main(String[] args) {
		Runnable task = new PrintNum(1,1000);
		Thread thread = new Thread(task);
		thread.start();
	}

}
