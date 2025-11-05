package com.maji.maojianwei.leetcode.java_language.thread;

public class PrintChar implements Runnable{
	
	private int times;
	private char ch;
	
	public PrintChar(char ch,int times) {
		this.ch = ch;
		this.times = times;
	}
	
	@Override
	public void run() {
		try {
			for(int i =0;i<times;i++) {
				System.out.print(ch + " ");
			}
			System.out.println();
			System.out.println();
			Thread.sleep(1000);
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	

}
