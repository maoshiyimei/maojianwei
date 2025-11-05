package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<String> future = threadPool.submit(new CallableTest());
		System.out.println(Thread.currentThread().toString());
		System.out.println(future.get());
	}
}
class CallableTest implements Callable<String>{
	@Override
	public String call() throws Exception {
		System.out.println("你好！");
		System.out.println("我是线程：" + Thread.currentThread().toString() );
		return "hello Alin";
	} 
	
}
