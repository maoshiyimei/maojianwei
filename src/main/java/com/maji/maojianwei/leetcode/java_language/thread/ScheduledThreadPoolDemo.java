package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor e = new ScheduledThreadPoolExecutor(2);
		e.scheduleAtFixedRate(new MyThread4(),0,1000,TimeUnit.MILLISECONDS);
		e.scheduleAtFixedRate(new MyThread4(),0,1000,TimeUnit.MILLISECONDS);

	}

}

class MyThread4 extends Thread{
	public void run() {
		System.out.println(Thread.currentThread().getId()+ "timeStamp:"+System.currentTimeMillis());
	}
}
