package com.maji.maojianwei.leetcode.java_language.thread;//缓冲区为1，消费者和生产者问题，实现同步


import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerDemo_Lock_Condition {
	private static Buffer buffer = new Buffer(100);

	public static void main(String[] args){

		ExecutorService executor  = Executors.newFixedThreadPool(2);
		executor.execute(new WriteTask());
		executor.execute(new ReadTask());
		executor.shutdown();
	}

	static class WriteTask implements Runnable{
		@Override
		public void run() {
			while(true){
				int n = (int)(Math.random() * 30) + 1;
				String s = getRandomString(n);
				buffer.write(s);
				System.out.println(Thread.currentThread().getName() + " write : " + s);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public String getRandomString(int n){
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i< n ; i++){
				sb.append( (char)('a' + (int)(Math.random()*26)));
			}
			return sb.toString();
		}
	}

	static class ReadTask implements Runnable{

		@Override
		public void run() {
			while(true){
				String s = buffer.read(15);
				System.out.println(Thread.currentThread().getName() + " read :"  + s);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Buffer{
		private static int capacity;
		private static List<Character> chars = new ArrayList<Character>(){};

		private static Lock lock = new ReentrantLock();
		private static Condition notFull = lock.newCondition();
		private static Condition notEmpty = lock.newCondition();

		public Buffer(int capacity) {
			this.capacity = capacity;
		}

		public int write(String s){
			lock.lock();
			try{
				while(chars.size()  == capacity){
					System.out.println(Thread.currentThread().getName() + " could not write " + s + ", have to wait, remain capacity: full " );
					notFull.await();
				}
				if(capacity - chars.size() < s.length()){
					s =s.substring(0, capacity-chars.size());
				}
				for(char c : s.toCharArray()){
					chars.add(c);
				}
				notEmpty.signal();
				return s.length();
			}catch (InterruptedException e){
				e.printStackTrace();
				return 0;
			} finally {
				lock.unlock();
			}
		}

		public String read(int n){
			if(n > capacity){
				n =capacity;
			}
			// 避免死锁
			if(n > chars.size()){
				n = chars.size();
			}

			lock.lock();
			try{
				while(chars.size() == 0){
					System.out.println(Thread.currentThread().getName() + " could not read " + n + ", have to wait, capacity = 0 ");
					notEmpty.await();
				}
				StringBuilder sb = new StringBuilder();
				for(int i = 0 ;i < n ;i++){
					sb.append(chars.remove(chars.size()-1));
				}
				return sb.toString();
			}
			catch (InterruptedException e){
				e.printStackTrace();
				return null;
			}
			finally{
				lock.unlock();
			}
		}

	}




}




