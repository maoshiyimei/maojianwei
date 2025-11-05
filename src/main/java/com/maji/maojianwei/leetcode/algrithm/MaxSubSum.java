package com.maji.maojianwei.leetcode.algrithm;
/*求解最长子段和的递归算法，分治原理，时间为O（nlogn)*/

public class MaxSubSum {
	private static int n =20;
	private static int leftFlag=0;//用于标记位置；
	private static int rightFlag=0;
	

	public static void main(String[] args){
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] =(int)(Math.random()*100)%50 -25;
			System.out.print(array[i]+"  ");
		}
		System.out.println();
		System.out.println("最长子段和"+ maxSubSum(array,0,n-1));
		for(int i =0;i<n;i++) {
			if(i==leftFlag) {
				System.out.print("[ "+array[i]+"  ");
			}
			else if(i == rightFlag) {
				System.out.print(+array[i]+" ]  ");
			}
			else {
				System.out.print(array[i]+"  ");
			}
		}
		int sum=0;
		for(int i =leftFlag;i<=rightFlag;i++) {
			sum+=array[i];
		}
		System.out.println("\n"+sum);
	}
	public static int maxSubSum(int[] array,int left,int right) {
		if(left == right)//递归出口
			return array[left];
		else {
			int mid =( left+right)/2;
			int leftMax = maxSubSum(array,left,mid);
			int tempLeftFlag = leftFlag;
			int tempRightFlag = rightFlag;
			int rightMax = maxSubSum(array,mid+1,right);
			if(leftMax<rightMax) {
				tempLeftFlag = leftFlag;
				tempRightFlag = rightFlag;
			}
			int midMax=maxMidSubSum(array,left,mid,right);
			
			//输出最大的，要么在左边，要么在右边，要么就是横跨中点的
			if(leftMax<midMax)
				leftMax = midMax;
			else {
				leftFlag = tempLeftFlag;
				rightFlag  = tempRightFlag;
			}
			return leftMax;
		}
	}
	
	public static int maxMidSubSum(int[] array,int left,int mid,int right) {
		int leftSum =0;
		int rightSum =0;
		int temp1=-999999;
		int temp2=-999999;
		leftFlag = mid;
		rightFlag =mid;
		int i =mid;
		int j =mid+1;
		for(;i>=left;i--) {//左边计算最大和，连续的，加到最大为止；
			leftSum+=array[i];
			if(leftSum > temp1 ) {
				temp1=leftSum;
				leftFlag = i;
			}
		}
		for(;j<=right;j++) {//右边计算最大和，也是连续的，加到最大为止
			rightSum+=array[j];
			if(rightSum >temp2) {
				temp2=rightSum;
				rightFlag =j;
			}
		}
		return temp1+temp2;
	}

}
