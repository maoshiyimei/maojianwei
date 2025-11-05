package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class: �ҳ������г��ִ�������N/K������Ԫ��
 * ���磺 ����1,2,1,3,1,5,6 k =3 ,���Ϊ1
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/9 , 15:12
 */
public class Array_3_NK {

    public static void main(String[] args ){
        int[] data = {1,4,3,4,3,7,6,4,1,3,4,8};
        int[] result ;
        System.out.println( " k= " + 4 + " :" );
        result = getNumber(data, 4);
        for( int x : result){
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println( " k= " + 6 + " :" );
        result = getNumber(data, 6);
        for( int x : result){
            System.out.print(x + " ");
        }
        System.out.println();


    }
    /* ˼·�� �볲ԭ������n/k�Σ���ÿ��ɾ�� k ����ͬ�����֣�ֱ������ɾ��Ϊֹ
    * ����ʵ�֣���ʹ��map,Ȼ��ѭ�� n/k�Σ�ÿ��ÿ��Ԫ�ؾ���һ�� ʱ�临�Ӷ�Ϊ n  */

    public static int[] getNumber( int[] data, int k ){
        int n =data.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            if(map.containsKey(data[i])){
                map.put(data[i], map.get(data[i])+1);
            }
            else{
                map.put(data[i], 1);
            }
        }
        for(int i = 0 ; i< n/k ; i++ ){
            Iterator it = map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                if(entry.getValue().equals(1)){
                        it.remove();
                }
                else{
                    entry.setValue((int)entry.getValue()-1 );
                }
            }
        }
        int[] result = new int[map.size()];
        int i = 0;
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            result[i++] = (int) entry.getKey();
        }
        return result;
    }
}
