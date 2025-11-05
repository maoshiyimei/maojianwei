package com.maji.maojianwei.leetcode.java_language.thread;//缓冲区为1，消费者和生产者问题，实现同步
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ConsumerAndProducer {
	private static Buffer buffer =new Buffer();

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
					buffer.write((int)(Math.random()*100));
					Thread.sleep(1000);//休眠的作用是不要太快，不影响线程互斥的问题
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
					buffer.read();
					Thread.sleep(1000);
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	private static class Buffer{
		private static final int capacity = 1;
		private LinkedList<Integer> queue =new LinkedList<>();
		private static Lock lock =new ReentrantLock();
		private static Condition empty = lock.newCondition();
		private static Condition full = lock.newCondition();
		public int read(){
			int value=0;
			lock.lock();
			try {
				while(queue.isEmpty()) {//循环必不可少，要不然生产者永远在等待
					System.out.println("consumer waiting...");
					full.await();
				}
				value = queue.remove();
				System.out.println("consumer reader: "+value);
				empty.signal();	
			}
			catch(InterruptedException ex) {ex.printStackTrace();}
			finally {
				lock.unlock();
			}
			return value;	
		}
		public void write(int value) {
			lock.lock();
			try {
				while(queue.size() == capacity) {
					System.out.println("producer waiting ...");
					empty.await();
				}
				queue.offer(value);
				System.out.println("producer write : "+value);
				full.signal();
			}
			catch(InterruptedException ex) {ex.printStackTrace();}
			finally {
				lock.unlock();
			}
		}
		
		
	}

}
