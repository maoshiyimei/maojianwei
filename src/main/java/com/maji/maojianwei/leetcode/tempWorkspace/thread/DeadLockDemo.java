package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class DeadLockDemo {

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();

	}

}
class ShareObject1{};
class ShareObject2{};
class Thread1 extends Thread{
	public void run() {
		synchronized(ShareObject1.class) {
			System.out.println("线程1获得资源1的锁");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(ShareObject2.class) {
				System.out.println("线程1获得资源2的锁");
			}
		}
	}
}
class Thread2 extends Thread{
	public void run() {
		synchronized(ShareObject2.class) {
			System.out.println("线程2获得资源2的锁");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(ShareObject1.class) {
				System.out.println("线程2获得资源1的锁");
			}
		}
	}
}
