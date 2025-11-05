package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class PrintNum implements Runnable{
	private int number;
	private int times;
	public PrintNum(int number,int times) {
		this.number = number;
		this.times =times;
	}
	@Override
	public void run() {
		Thread thread2 = new Thread(new PrintChar('*',100));
		thread2.start();
		try {
			for(int i=0;i<times;i++) {
				System.out.print(" "+number);
				if(i==50)
					thread2.join();
			}
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
