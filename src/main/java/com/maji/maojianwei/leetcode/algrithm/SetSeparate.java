package com.maji.maojianwei.leetcode.algrithm;//�����Ӽ��ĵݹ���㷨

public class SetSeparate {

	public static void main(String[] args) {
		System.out.println("20 ��Ԫ�صĻ��ֳ��Ӽ�������ǣ�");
		for(int i =1;i<=20;i++){
			System.out.println("(20 "+i+")->"+setSeparate(20,i));
		}
	}
	public static int setSeparate(int n,int k) {
		if(k==1 || n==k)
			return 1;
		else {
			return setSeparate(n-1,k-1)+k*setSeparate(n-1,k);
		}
	}

}
