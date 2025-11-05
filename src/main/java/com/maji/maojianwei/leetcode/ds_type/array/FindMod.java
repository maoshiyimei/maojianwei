package com.maji.maojianwei.leetcode.ds_type.array;

/**
 * Class:找出整形数组中的超过一半的数字
 * 思路： 两两比较，不同删除，相同累计，具体实现时利用一个count来统计当前数量最多的值，当不同相消，相同累加。最后保留的值就是结果。
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/17 , 19:40
 */
public class FindMod {

    /**
     * 如果没有这个前提条件， 是不正确的，
     * @param array
     * @return
     */

    public static int findMod(int[] array){
        if( array == null ){
            return -1;
        }
        if(array.length ==1){
            return array[0];
        }

        int cur = array[0];
        int count = 1;
        for( int i = 1; i< array.length; i++){
            if( array[i] == cur){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                cur = array[i];
                count = 1;
            }
        }
        return cur;
    }

}
