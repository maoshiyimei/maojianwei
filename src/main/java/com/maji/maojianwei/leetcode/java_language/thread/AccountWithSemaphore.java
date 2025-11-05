package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class AccountWithSemaphore {
	private static Account account =new Account();

	public static void main(String[] args) {
		ExecutorService executor =Executors.newCachedThreadPool();
		for(int i =0;i<100;i++) {
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		while(!executor.isTerminated()) {}
		System.out.println("最终存款为："+account.getBalance());

	}
	//内部类；
	private static class Account{ 
		private int balance =0;
		
		private Semaphore s =new Semaphore(1);
		public int getBalance() {
			return balance;
		}
		public void deposit(int amount) {
			try {
				s.acquire();
				int newBalance = balance+amount;
				Thread.sleep(100);
				balance =newBalance;
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			finally {
				s.release();
			}
		}
	}

	private static class AddPennyTask implements Runnable{
		@Override 
		public void run() {
			account.deposit(1);
		}
	}
}

