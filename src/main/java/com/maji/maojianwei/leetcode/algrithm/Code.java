package com.maji.maojianwei.leetcode.algrithm;
import java.util.*;
public class Code {
	public static String message;
	public static String codeMessage;
	public static int N ;
	public static int count =0;

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		message= in.nextLine();
		in.close();
		code();
		System.out.println("编码为："+codeMessage);
		N = codeMessage.length();
		decode(0,"");
		System.out.println("总共有："+count+"种解码结果！");
		
		

	}
	public static void decode(int n,String s) {
		if(n == N) {
			count++;
			if(s.equals(message)) {
				System.out.println(s+"****");
			}
			else{
				System.out.println(s);
			
			}
		}
		else {
			int num =(int)(codeMessage.charAt(n)-'0');
			if(num>=3 && num<=9) {
				s=s+(char)('a'+num-1);
				decode(n+1,s);
			}
			else {
				if(n<N-1) {
					int nextNum = (int)(codeMessage.charAt(n+1)-'0');
					if(nextNum == 0) {
						s=s+(char)('a'+(num*10-1));
						decode(n+2,s);
					}
					else {
						String temp =s;
						s=s+(char)('a'+num-1);
						decode(n+1,s);
						if(!(num==2 && nextNum>6)) {
							s=temp;
							s=s+(char)('a'+num*10+nextNum-1);
							decode(n+2,s);
						}
					}
				}
				else {
					s=s+(char)('a'+num-1);
					decode(n+1,s);
				}
			
			}
		}
	}
	public static void code() {
		StringBuilder s = new StringBuilder();
		int n =message.length();
		for(int i =0;i<n;i++) {
			char  ch = message.charAt(i);
			int codeNum = (int)(ch-'a')+1;
			s.append(codeNum);
		}
		codeMessage = s.toString();
	}

}
