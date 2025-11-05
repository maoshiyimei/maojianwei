package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AccountWithSync2 {
	private static Account account =new Account();

	public static void main(String[] args) {
		ExecutorService executor =Executors.newCachedThreadPool();
		for(int i =0;i<100;i++) {
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		while(!executor.isTerminated()) {}
		System.out.println("���մ��Ϊ��"+account.getBalance());

	}
	//�ڲ��ࣻ
	private static class Account{ 
		private  int balance =0;
		public int getBalance() {
			return balance;
		}
		public synchronized void deposit(int amount) {
		
			try {
				int newBalance = balance+amount;
				balance =newBalance;
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {}	
		}
	}

	private static class AddPennyTask implements Runnable{
		@Override 
		public void run() {
			account.deposit(1);
		}
	}
}

