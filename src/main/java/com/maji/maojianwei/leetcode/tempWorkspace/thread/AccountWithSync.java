package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class AccountWithSync {
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
		private static Lock lock =new ReentrantLock();
		private  int balance =0;
		public int getBalance() {
			return balance;
		}
		public void deposit(int amount) {
			lock.lock();//�����
			try {
				int newBalance = balance+amount;
				balance =newBalance;
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {}
			finally {
				lock.unlock();//�ͷ�����
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
