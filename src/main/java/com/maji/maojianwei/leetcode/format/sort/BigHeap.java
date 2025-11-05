package com.maji.maojianwei.leetcode.format.sort;

import java.util.ArrayList;

public class BigHeap<T extends Comparable<T>> {
	private ArrayList<T> list = new ArrayList<>();
	
	public BigHeap(){}
	public BigHeap(T[] array){
		for(int i= 0;i<array.length;i++)
			push(array[i]);
		heapSort(array);
		
	}
	public void heapSort(T[] array) {
		for(int i =array.length-1;i>=0;i--) {
			array[i]= pop();
		}
	}
	
	public void push(T x) {
		
		
		list.add(x);
		int currentIndex = list.size()-1;//堆的最后元素的索引；
		while(currentIndex>0) {
			int parentIndex = (currentIndex-1)/2;
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				T temp =list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			currentIndex = parentIndex;
		}	
	}
	
	public T peek() {//取堆顶元素，即最大值
		return list.get(0);
	}
	
	public T pop() {//取堆顶元素，并删除；
		if(list.size()==0)
			return null;
		T peek = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		//与最后一个元素替换，并删除，下面接着向下调整
		int currentIndex =0;
		while(currentIndex < list.size()){
			int tempMax =currentIndex;
			int leftChildIndex = currentIndex*2+1;
			int rightChildIndex = currentIndex*2+2;
			if(leftChildIndex>list.size()-1)
				break;//结束调整
			if(list.get(leftChildIndex).compareTo(list.get(tempMax))>0)
				tempMax= leftChildIndex;
			if(rightChildIndex>list.size()-1)
				break;//结束调整
			if(list.get(rightChildIndex).compareTo(list.get(tempMax))>0)
				tempMax= rightChildIndex;
			if(tempMax != currentIndex) {
				T temp =list.get(currentIndex);//交换
				list.set(currentIndex, list.get(tempMax));
				list.set(tempMax, temp);
				currentIndex =tempMax;
			}
			else
				break;//结束比较
		}
		return peek;
	}
	
	public int size() {
		return list.size();
	}
	//public void remove(int x) {}//删除算法；
}
