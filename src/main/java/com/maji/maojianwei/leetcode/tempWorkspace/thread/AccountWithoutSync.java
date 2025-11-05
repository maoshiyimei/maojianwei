package com.maji.maojianwei.leetcode.tempWorkspace.thread;
import java.util.concurrent.*;

public class AccountWithoutSync {
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
		public void deposit(int amount) {
			int newBalance = balance+amount;
			
			//�ӻ�ʱ��
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {}
			
			balance =newBalance;
		}
	}

	private static class AddPennyTask implements Runnable{
		@Override 
		public void run() {
			account.deposit(1);
		}
	}
}

