package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.*;

public class ConsumerAndProducerWithBlockingQueue {

	private static ArrayBlockingQueue<Integer> buffer =new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) {
		ExecutorService executor  = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	private static class ProducerTask implements Runnable{
		@Override
		public void run() {
			try {
				while(true) {
					int value =(int)(Math.random()*100);
					buffer.put(value);
					System.out.println("producer read: "+value);
					Thread.sleep(10);
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	private static class ConsumerTask implements Runnable{
		@Override
		public void run() {
			try {
				while(true) {
					int value = buffer.take();
					System.out.println("consumer write: "+value);
					Thread.sleep(1000);
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

}
