package com.maji.maojianwei.leetcode.tempWorkspace.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionThreadDemo {
	private static final String file = "originalFile.txt";

	public static void main(String[] args) throws IOException {
		try {
			createFile(file,10000);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String[] records = (br.readLine()).split(",");
			br.close();
			//分别读入十个文件中，每个文件中1000个数据；
			int index =0;
			for(int i =0;i<10;i++) {//调用十次，建立20个线程
				int[] data = new int[1000];
				for(int j =0;j<1000;j++) {
					data[j] = Integer.parseInt(records[index++]);
				}
				PrintGroup print = new PrintGroup(data,i+1);
				print.startPrint();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//创建文件含有10000个数据,文件只有一行；
	public static void createFile(String fileName,int count) throws IOException {
		File file = new File(fileName);
		FileWriter fw =new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw,true);
		
		for(int i =0;i<count;i++) {
			pw.write((int)(Math.random()*100+1)+",");
		}
		pw.flush();
		pw.close();
	}

}
class PrintGroup{
	private  volatile int count =0;
	private Lock lock =new ReentrantLock();
	private int index = 0;
	private volatile int oddIndex  = 0;
	private volatile int evenIndex = 0;
	private int n =1000;
	private boolean flag = true;//是不是第一次输入，决定次序
	private int[] data =new int[1000];
	private int[] result = new int[1000];
	private int id = 0;
	private OddThread  oddThread= null;
	private EvenThread evenThread= null;
	private Condition oddLock  = lock.newCondition();
	private Condition evenLock = lock.newCondition();
	private PrintWriter pw= null;//输出文件
	private File outFile  = null;
	
	public PrintGroup(int[] data ,int id) throws IOException {
	this.data = data;
		this.id = id;
		outFile = new File("outFile"+this.id+".txt");
		pw = new PrintWriter(new FileWriter(outFile),true);
	}
	
	public void startPrint() {
		oddThread  = new OddThread();
		evenThread = new EvenThread();
		oddThread.start();
		evenThread.start();
	}
	
	class OddThread extends Thread{
		@Override
		public void run() {
			while(true) {
				
				try {
					lock.lock();//先获得锁！！
					if(flag) {	//如果是第一次，那么先让偶数先打印！				
						flag = false;
						evenLock.await();//释放偶数锁
					}
					for(int i =0;i<10;) {//打印十个以后再打印偶数，交替打印
						//结束打印，1000个数据全部保存;
						if(oddIndex>=n && evenIndex>=n) {
							pw.flush();
							pw.close();//结束也是由奇数线程负责的；
							return ;
						}
						//奇数已经打印完了，什么都不做！
						if(oddIndex >=n ){
							break;
						}
						if(data[oddIndex]%2 == 1) {
							result[index] = data[oddIndex];
							i++;
							pw.write(result[index]+" ");
							index++;
							pw.flush();
							addCount();
						}
						oddIndex++;
					}
					pw.write("\n");
					oddLock.signal();//得到奇数锁
					evenLock.await();//释放偶数锁
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					oddLock.signal();//????
					lock.unlock();
				}
			}
		}
	}
	
	class EvenThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					while(flag) {
						Thread.sleep(1);//如果是第一次，则让奇数线程释放锁；促发
					}
					lock.lock();
					for(int i =0;i<10;) {
						if(evenIndex>=n && oddIndex>=n) {
							pw.flush();
							return;
						}
						if(evenIndex>=n) {
							break;
						}
						if(data[evenIndex]%2 == 0) {
							i++;
							result[index] = data[evenIndex];
							pw.write(result[index]);
							pw.flush();
							index++;
							addCount();
						}
						evenIndex++;
					}
					pw.write("\n");
					evenLock.signal();//得到偶数锁
					oddLock.await();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally{
					evenLock.signal();
					lock.unlock();
					
				}
			}
			
		}
	}
	
	public void addCount(){
		count++;
		if(count%1000 == 0){
			System.out.println("已经完成："+count+" /"+id);
			
		}
	}
	
	
}
