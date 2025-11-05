package com.maji.maojianwei.leetcode.algrithm;

public class TSPDemo {
	private static int N =4;
	private static int[][] distance = new int[N][N];
	private static int[] path = new int[N];
	private static int[] bestPath = new int[N];
	private static int totalDistance = 0;
	private static int bestDistance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		initCities();
		printCities();
		//从第一个城市出发,
		for(int i =0;i<N;i++) {//初始化，很关键。相当于最初的排列，然后回溯基于此！！！！！
			path[i]=i;
			bestPath[i] =i;
		}
		tsp(1);//先找第二个城市
		System.out.println("最佳距离为："+bestDistance);
		for(int i =0;i<N;i++) {
			System.out.printf("%1d%s",bestPath[i]+1," -> ");
		}
		System.out.printf("%1d",1);
		System.out.println();
	}
	public static void tsp(int n){
		if(n == N){//已经安排到最后一个城市了，结束方案；注意这里不能是N-1，因为这样会漏掉一个距离！
			if(distance[path[n-1]][0]+totalDistance < bestDistance) {//加上最后回到起始地点
				bestDistance = distance[path[n-1]][0]+totalDistance;
				for(int i =0;i<N;i++) {
					bestPath[i] = path[i];
				}
			}
		}
		else {
			for(int i=n;i<N;i++) {
				if(distance[path[n-1]][path[i]]+totalDistance <bestDistance) {
					
					int temp = path[n];path[n]= path[i];path[i] = temp;
					//注意n和i的区别
					totalDistance+=distance[path[n-1]][path[n]];
					
					print();
					tsp(n+1);
					
					totalDistance-=distance[path[n-1]][path[n]];
					temp = path[n];path[n]= path[i];path[i] = temp;
					
					
				}
				
			}
			
		}
		
	}
	public static void print() {
		System.out.print("[");
		for(int i =0;i<N;i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println("],td=("+totalDistance+"),bd=("+bestDistance+")");
	}
	public static void initCities() {//初始化距离
		for(int i =0; i<N; i++) {
			for(int j =i+1; j<N;j++){
				distance[i][j] = (int)(Math.random()*10+1);
				distance[j][i] = distance[i][j];
			}
		}
	}
	public static void printCities() {//显示距离矩阵
		System.out.printf("%4s", "|");
		for(int i =0;i<N;i++) {
			System.out.printf("%4d", i+1);
		}
		System.out.println();
		for(int i =0;i<N+1;i++) {
			System.out.printf("%4s","----");
		}
		System.out.println();
		for(int i =0;i<N;i++) {
			System.out.printf("%3d%c",i+1,'|');
			for(int j =0;j<N;j++) {
					System.out.printf("%4d", distance[i][j]);
			}
			System.out.println();
			for(int k =0;k<N+1;k++) {
				System.out.printf("%4s","----");
			}
			System.out.println();
			
		}
	}

}
