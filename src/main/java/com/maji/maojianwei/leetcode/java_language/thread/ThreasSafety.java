package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.ArrayList;


public class ThreasSafety {

	public static void main(String[] args) {
		MyStack s = new MyStack();
		new Thread() {
			public void run() {
				try {
					System.out.println("thread1"+s.pop());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			public void run() {
				s.push(1);
			}
		}.start();
		new Thread() {
			public void run() {
				try {
					System.out.println("thread2"+s.pop());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

	}
	

}

class MyStack{
	private ArrayList<Integer> stack = new ArrayList<>();
	
	public synchronized void push(int val) {
		synchronized(this) {
			stack.add(val);
			notify();
		}
	}
	
	public synchronized int pop() throws InterruptedException {
		synchronized(this) {
			if(stack.size()<=0)
				wait();
			return stack.remove(stack.size()-1);
		}
	}
}
