package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class WaitDemo {
	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start();
		synchronized (thread) {
			try {
				System.out.println("等待A线程结束：");
				thread.wait();
				System.out.println(thread.total);
			}
			catch(InterruptedException e) {}
		}
	}
}
class ThreadA extends Thread {
	public int total=0;
	@Override
	public void run() {
		synchronized (this) {
			for(int i =0;i<100;i++) {
				total+=i;
			}
			notify();
		}
	}
}

