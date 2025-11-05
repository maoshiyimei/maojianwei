package com.maji.maojianwei.leetcode.algrithm;
//1到n的排列，每数m个人就出队，直到只有一个人，为胜利者！
public class CallTheRoll {
	private static int n = 10;
	private static int m =4;
	public static void main(String[] args) {
			solution();
	}
	public static void solution() {
		System.out.println("enter the solution");
		Node head = new Node(1);
		Node p=head;
		for(int i =2;i<=n;i++) {
			Node newNode = new Node(i);
			p.next = newNode;
			p=newNode;
		}
		p.next= head;
		Node pre =p;
		p=head;
		while(p.next!=head) {
			System.out.print(p.value+" ");
			p=p.next;
		}
		System.out.println(p.value+" ");
		pre =p;
		p=head;
		while(pre != p ) {
			for(int i =1;i<m;i++) {
				pre = p;
				p=p.next;
			}
			
			System.out.print(p.value +" ");
			pre.next=p.next;
			p=pre.next;
		}
		System.out.println();
		System.out.print(p.value);
		
	}
	
	 

}
class Node {
	public int value;
	public Node next = null;
	public Node(int i) {
		this.value = i;
	}
}
