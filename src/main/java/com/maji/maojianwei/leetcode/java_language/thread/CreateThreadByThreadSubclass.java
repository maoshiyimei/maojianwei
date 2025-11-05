package com.maji.maojianwei.leetcode.java_language.thread;

public class CreateThreadByThreadSubclass {

	public static void main(String[] args) {
		Thread thread = new WelcomeThread();
		thread.start();
		System.out.println("1.welcome! I'm "+Thread.currentThread().getName()+" .");

	}

}

class WelcomeThread extends Thread{
	@Override
	public void run() {
		System.out.println("2.welcome! I'm "+Thread.currentThread().getName()+" .");
	}
}
