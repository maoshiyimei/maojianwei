package com.maji.maojianwei.leetcode.ds_type.array; /**
 * Class: box[]中的box[i]表示第i个盒子中有的小球个数，
 * 增加最少的秋数是的所有的盒子中的数目不同；
 * 思路：先排序，然后遍历一次即可，遍历过程中做两件事：记录可以插入的位置，以及重复的元素（需要修改的）
 * 然后按顺序，一次完善，先优先使用可以插入的位置，不行的话就以最大值后面连续取值即可；
 *
 * * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/6 , 18:05
 */
import java.util.*;

public class MakeBoxDifferent {

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int n = in.nextInt();
        int[] box = new int[n];
        for( int i = 0 ; i < n ; i++){
            box[i] = in.nextInt();
        }
        Arrays.sort( box );
        int sum = 0 ;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> value = new ArrayList<>();
        int foreBox = box[0];
        for(int i = 1 ; i<n ; i++){
            if(box[i] - box[i-1] >=2){
                for( int j = box[i-1]+1; j<box[i] ; j++){
                    list.add(j);
                }
            }
            if( box[i] == foreBox){
                value.add(box[i]);
            }
            else{
                foreBox = box[i];
            }
        }
        int accValue = box[n-1]+1;
        for( int x : value){
            if(!list.isEmpty()){
                sum += list.get(0) - x ;
                list.remove(0);
            }
            else{
                sum += accValue-x;
                accValue++;
            }
        }
        System.out.println( sum );

    }

}



