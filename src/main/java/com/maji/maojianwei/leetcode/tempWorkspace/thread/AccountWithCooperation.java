package com.maji.maojianwei.leetcode.tempWorkspace.thread;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithCooperation {
	private static Account account =new Account();
	
	public static void main(String[] args) {
		ExecutorService executor =Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		System.out.println("Thread 1\t\tThread\t\tBalance");
	}
	private static class DepositTask implements Runnable{
		@Override
		public void run(){
			try {
				int count=0;
				while(count++<50) {
					account.deposit((int)(Math.random()*10) +1);
					Thread.sleep(1000);
				}
			}
			catch(InterruptedException ex) {System.out.println("sleep exception!");}
		}
	}
	
	private static class WithdrawTask implements Runnable{
		@Override
		public void run() {
			int count =0;
			while(count++<20) {
				account.withdraw( (int)(Math.random()*10) +1);
			}
		}
	}
	
	private static class Account{
		private int  balance =0;
		private static Lock lock =new ReentrantLock();
		private static Condition newDeposit =lock.newCondition();
		
		public int getBalance() {
			return balance;
		}
		public void withdraw(int amount){
			lock.lock();
			try {
				while(balance <amount) {
					System.out.println("\t\twaiting for a deposit...");
					newDeposit.await();
				}
				
				balance-=amount;
				System.out.println("\t\twithdraw:" + amount + "$\t\t\t" +account.getBalance()+" $");
			}
			catch(InterruptedException ex) {}
			finally {
				lock.unlock();
			}
		}
		public void deposit(int amount) {
			lock.lock();
			try {
				balance+=amount;
				System.out.println("Deposit:"+amount+" $\t\t\t\t\t"+account.getBalance()+" $");
				newDeposit.signalAll();
			}
			finally {
				lock.unlock();
			}
			
		}
	}

}
