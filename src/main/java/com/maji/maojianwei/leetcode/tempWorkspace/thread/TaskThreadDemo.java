package com.maji.maojianwei.leetcode.tempWorkspace.thread;

public class TaskThreadDemo {

//	public static void main(String[] args) {
//		//��������
//		Runnable printA = new PrintChar('a',200);
//		Runnable printB = new PrintChar('b',200);
//		Runnable printNum = new PrintNum(200);
//		//�����߳�
//		Thread thread1 = new Thread(printA);
//		Thread thread2 = new Thread(printB);
//		Thread thread3 = new Thread(printNum);
//		//�����߳�
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		//���治���߳���ִ�У�˳��ִ��
//		printA.run();
//		printB.run();
//		printNum.run();
//	}
//
//}
//
//class PrintChar implements Runnable{
//	private char ch;
//	private int times;
//	public PrintChar(char ch,int times) {
//		this.ch = ch;
//		this.times = times;
//	}
//	@Override
//	public void run() {
//		for(int i =0;i<times;i++) {
//			System.out.print(ch);
//		}
//		System.out.println();
//	}
//}
//
//class PrintNum implements Runnable{
//	private int lastNum;
//	public PrintNum(int num) {
//		lastNum = num;
//	}
//	@Override
//	public void run() {
//		for(int i =0;i<lastNum;i++) {
//			System.out.print("" + i);
//		}
//		System.out.println();
//
//	}
}