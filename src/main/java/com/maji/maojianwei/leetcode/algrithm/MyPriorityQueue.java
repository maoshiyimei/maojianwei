package com.maji.maojianwei.leetcode.algrithm;

public class MyPriorityQueue<T extends Comparable<T>>{
	private BigHeap<T> heap =new BigHeap<>();
	public void enQueue(T o) {
		heap.push(o);
	}
	public T deQueue() {
		return heap.pop();			
	}
	public int getSize() {
		return heap.size();
	}
}
