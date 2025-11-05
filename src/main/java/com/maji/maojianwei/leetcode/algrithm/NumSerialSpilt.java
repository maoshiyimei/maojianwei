package com.maji.maojianwei.leetcode.algrithm;
import java.util.Scanner;

public class NumSerialSpilt {
	
	private int[] data;
	private int[] insert;
	private int[] sum;
	
	
	public NumSerialSpilt(int n,int m){
		initData(n);
		initInsert(n);
		initSum(m);
		split(n,m);
		printResult(n,m);
	}
	
	//��ʼ���������У�0-n-1
	public void initData(int n ) {
		System.out.println("��������Ϊ��");
		data =new int[n];
		for(int i= 0;i<data.length;i++) {//�������,��ʼ��
			data[i] =(int)(Math.random()*20);
			System.out.printf("%4d",data[i]);
		}
		System.out.println();
	}

	//��ʼ������λ�ã�insert[1-n-1]��Ч��1��ʾ���֣�0��ʾ�����֣�
	public void initInsert(int n) {
		insert =new int[n];
		for(int i =0;i<insert.length;i++) {
			insert[i]=0;
		}
	}
	
	//��ʼ���ֶκ�0-m-1
	public void initSum(int m) {
		sum =new int[m];
		for(int i =0;i<m;i++) {
			sum[i] = 0;
		}
	}

	public void split(int n,int m) {
		int k =n/m;
		int i = 0;
		int j =0;
		
		//�״λ��֣�
		while(i<n) {
			while(j<m-1){
				for(int a =0;a<k;a++) {
					sum[j]+=data[i];
					i++;
				}
				insert[i] =1;//ֻ��m-1��λ�ñ���ֵΪ1
				j++;
			}
			sum[j]+=data[i];
			i++;
		}
		printResult(n,m);
		//����,�����Ӷ����·���һ�����ݣ�������Ƿ����
		int flag= 0;
		while(flag == 0){
			flag =1;
			i=1;
			j=0;
			while(j<m-1){
				if(insert[i] == 1){
					System.out.print(j);
					if(sum[j]< sum[j+1] && (sum[j]+data[i] )<sum[j+1]) {
						insert[i+1] = 1;
						insert[i]= 0;
						sum[j]=sum[j]+data[i];
						sum[j+1] = sum[j+1]-data[i];
						flag =0;
						i+=2;
					}
					else if(sum[j] > sum[j+1] && sum[j]>(sum[j+1]+data[i-1])){
						insert[i-1] = 1;
						insert[i]= 0;
						sum[j]=sum[j]-data[i-1];
						sum[j+1] = sum[j+1]+data[i-1];
						flag =0;
						i++;
					}
				   j++;
				}
				else
					i++;
			}
			printResult(n,m);
		}
	}
		
	//��������
	public void printResult(int n,int m) {
		int i;
		for(i =1;i<n;i++){
			if(insert[i]==1)
				System.out.printf("%3d|",data[i-1]);
			else
				System.out.printf("%4d",data[i-1]);
		}
		System.out.printf("%4d",data[i-1]);
		System.out.println();
		for(int j =0;j<m;j++) {
			System.out.printf("%10d\n",sum[j]);
		}
		System.out.println("  :�����ֶκ�Ϊ ("+getMax(m)+")");
		System.out.println();
		
	}
	//��������ֶκͣ�
	public int getMax(int m) {
		int temp =sum[0];
		for(int i =1;i<m;i++) {
			if(sum[i] >temp)
				temp =sum[i];
		}
		return temp;
	}
	//������
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("���������ָ����Լ����ֵ��ֶ�����");
		int n = input.nextInt();
		int m= input.nextInt();
		input.close();
		new NumSerialSpilt(n,m);
	}
}