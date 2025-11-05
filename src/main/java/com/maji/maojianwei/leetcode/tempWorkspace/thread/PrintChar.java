package com.maji.maojianwei.leetcode.tempWorkspace.thread;

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
				
				if(i%20==0) {
					System.out.println();
					Thread.sleep(1);
				}
				System.out.print(" "+ch);
			}
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	

}
