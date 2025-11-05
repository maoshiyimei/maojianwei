package com.maji.maojianwei.leetcode.algrithm;

public class NoAAA {

	public static void main(String[] args) {
		System.out.println(strWithout3a3b(3,5));
		System.out.println(strWithout3a3b(10,4));
		System.out.println(strWithout3a3b(6,6));
		System.out.println(strWithout3a3b(31,19));

	}
public static String strWithout3a3b(int A, int B) {
        
        
        
        if(A == B){
            StringBuilder s = new StringBuilder("");
            for(int i =0;i<A;i++)
                s.append("ab");
            return s.toString();
        }
        else{
            char ch1 = A>B?'a':'b';
            char ch2 = A>B?'b':'a';
            int len1 = Math.max(A,B);
            int len2 = Math.min(A,B);
            String s1 = ""+ch1+ch1+ch2;
            String s2 = ""+ch1+ch2;
            StringBuilder s = new StringBuilder("");
            while(len1 >= (len2*2) ){
                s.append(s1);
                len1-=2;
                len2--;
            }
            while(len2>0){
                s.append(s2);
                len1--;
                len2--;
            }
            while(len1>0){
                s.append(ch1);
                len1--;
            }
            return s.toString();
        }
    }

}
