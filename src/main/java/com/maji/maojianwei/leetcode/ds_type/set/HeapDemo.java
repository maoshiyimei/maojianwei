package com.maji.maojianwei.leetcode.ds_type.set;


import com.maji.maojianwei.leetcode.format.sort.BigHeap;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/30 , 11:23
 */
public class HeapDemo {
    public static void main(String[] args){
        BigHeap<Integer> heap = new BigHeap<>();
        for(int i  = 0 ; i < 10 ; i++ ) {
            int value = (int) (Math.random() * 100);
            System.out.print(value + " ");
            heap.push(value);

            System.out.print(":" + heap.peek() + ", ");
        }
        System.out.println();
        for(int i = 0 ; i < 10; i ++) {
            System.out.print(heap.pop()+" ");
        }




    }
}
