package com.maji.maojianwei.leetcode.tempWorkspace.thread;
import java.util.concurrent.*;

public class ExectuorDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new PrintChar('a',40));
		executor.execute(new PrintChar('s',40));
		executor.execute(new PrintChar('w',40));
		executor.shutdown();
		}
}
