package com.maji.maojianwei.leetcode.algrithm;

public class BestAssign {
	private static int task = 6;
	private static int machine= 3;
	private int[] taskTime=new int[task];
	private int[] machineTime =new int[machine];
	private int minTime;
	private int[] alloc =new int[task];
	private int[] bestAlloc=new int[task];
	
	public BestAssign() {//�޲ι��캯��
		for(int i =0;i<task;i++) {
			taskTime[i]=(int)(Math.random()*15)+1;
		}
		for(int i =0;i<machine;i++) {//��ʼ��
			machineTime[i] =0;
		}
		minTime = 100000;
	}

	public static void main(String[] args) {
		BestAssign assign = new BestAssign();
		assign.backTrack(0);
		assign.printResult();
	}
	public void backTrack(int n) {
		if(n>=task){
			int tempTime = getMaxTime();
			if(tempTime<minTime){
				minTime = tempTime;
				for(int i =0;i<task;i++)
					bestAlloc[i] = alloc[i];
			}
		}
		else {
			for(int i =0;i<machine;i++){
				alloc[n]=i;
				machineTime[i]= machineTime[i]+taskTime[n];
				if(machineTime[i]<minTime)
					backTrack(n+1);
				machineTime[i]=machineTime[i]-taskTime[n];
				
			}
			
		}
	}
	public int getMaxTime() {
		int maxTime = machineTime[0];
		for(int i =1;i<machine;i++) {
			if(machineTime[i]>maxTime)
				maxTime = machineTime[i];		
		}
		return maxTime;
	}
	public void printResult(){
		System.out.println("����������Ҫʱ��Ϊ��");
		for(int i =1;i<=task;i++) {
			System.out.print(taskTime[i-1]+" ");
		}
		System.out.println("\n���䷽����");
		for(int i =1;i<=task;i++) {
			System.out.println("task"+i+"���������"+(bestAlloc[i-1]+1));
		}
		System.out.println("���ʱ��Ϊ��"+minTime);
	}

}
