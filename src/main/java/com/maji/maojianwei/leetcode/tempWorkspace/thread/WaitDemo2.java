package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class WaitDemo2 {
	public static void main(String[] args) {
		ThreadB thread = new ThreadB();
		thread.start();
		synchronized (thread) {
				System.out.println("等待B线程结束：");
				System.out.println(thread.total);
		}
	}
}
class ThreadB extends Thread {
	public int total=0;
	@Override
	public void run() {
		synchronized (this) {
			for(int i =0;i<100;i++) {
				total+=i;
			}
		}
	}
}

