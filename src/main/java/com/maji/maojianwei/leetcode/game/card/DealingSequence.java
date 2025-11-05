package com.maji.maojianwei.leetcode.game.card;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/** 发牌序列
 * @author weitong
 * @date 2022/02-19 9:28 下午
 */
public class DealingSequence {
    /**
     * 给定一个数组（初始排列）,每次从最上面拿一张，然后将最上面一张放到最底部，继续上述操作直至发牌完成，得到发牌序列
     * @param array
     * @return
     */
    public static int[] getDealingSequence(int[] array){

        int[] res = new int[array.length];
        // 初始化成队列
        Queue<Integer> queue = new LinkedList<>();
        for(int x : array){
            queue.offer(x);
        }
        int i = 0;
        while( !queue.isEmpty()){
            res[i++] = queue.poll();
            if(!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return res;
    }

    public static int[] getDealingSequence2(int[] array){
        int[] res = new int[array.length];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i< array.length; i++){
            linkedList.offerLast(array[i]);
        }
        int j = 0;
        while(!linkedList.isEmpty()){
            res[j++] = linkedList.pollFirst();
            if(!linkedList.isEmpty()){
                linkedList.offerLast(linkedList.pollFirst());
            }
        }
        return res;
    }

    /**
     * 方法1： 给定数量的数组，起最终各个元素的位置是固定的，现在已经知道了结果数组，根据这个位置的映射就可以直接得到原数组了
     * 关键：有时候直接找正向映射规则不好找，可以通过逆向思想求解
     * @param array
     * @return
     */
    public static int[] recoverDealingSequence(int[] array){
        int n = array.length;
        int[] seriesArray = new int[n];
        for(int i = 0 ;i < n; i++){
            seriesArray[i] = i;
        }
        int[] disturbedSeriesArray = getDealingSequence(seriesArray);
        int[] res = new int[n];
        for(int i = 0 ; i< n ;i++){
            res[disturbedSeriesArray[i]] = array[i];
        }
        return res;
    }


    /**
     * 正向： 队首 -> 出队 （poll）or（pollfirst）       队首 -> 队尾 ( poll - offer) or （pollfirst -> offerLast）
     * 反向： 队尾 -> 队首 （polllast - offerfirst)     进队 （offerfirst) -> 队首
     * 反项操作需要使用双向链表，队列无法完成对尾的放队首
     * @param array
     * @return
     */
    public static int[] recoverDealingSequence2(int[] array){
        if(array.length <= 1){
            return array;
        }
        // 使用双向链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.offer(array[array.length-1]);
        for(int i = array.length-2 ;i>=0; i--){
            linkedList.offerFirst(linkedList.pollLast());
            linkedList.offerFirst(array[i]);
        }
        int[] res = new int[array.length];
        for(int i = 0 ; i < array.length; i++){
            res[i] = linkedList.poll();
        }
        return res;

    }

}
