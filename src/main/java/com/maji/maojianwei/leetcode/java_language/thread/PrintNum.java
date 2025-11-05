package com.maji.maojianwei.leetcode.java_language.thread;

public class PrintNum implements Runnable{
	private int number;
	private int times;
	public PrintNum(int number,int times) {
		this.number = number;
		this.times =times;
	}
	@Override
	public void run() {

		try {
			for(int i=0;i<times;i++) {
				System.out.print(number + " ");
				if(i%50 == 0  && i != 0){
					System.out.println();
				}
				if(i%200 == 0 && i != 0 ){
					Thread thread = new Thread(new PrintChar('*',50));
					thread.start();
					thread.join();

				}
			}
			System.out.println();
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
