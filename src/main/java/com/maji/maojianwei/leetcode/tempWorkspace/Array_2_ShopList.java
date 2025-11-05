package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

/**�������ж���������ݡ�ÿ��������ݵĵ�һ��Ϊ��������n��m��1=��n, m=��1000�����ֱ��ʾ��ǩ�������Լ�СB�Ĺ����嵥�����е���Ʒ�����ڶ���Ϊ�ո�ָ���n������������ʾ�����ϸ�����Ʒ�ļ۸�ÿ�����Ĵ�С������100000������m��Ϊ�����嵥����Ʒ�����ƣ�
 * ������Ʒ����Ϊ�ǿյĲ�����32��������ĸ���ɵ��ַ�������֤�嵥�в�ͬ����Ʒ������������n��
 * ���̵���СB��Ҫ�����������Ʒ��
 *
 * 6 5
 * 3 5 1 6 8 1
 * peach
 * grapefruit
 * banana
 * orange
 * orange
 * ����� 11 30
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/18 , 11:39
 */
public class Array_2_ShopList {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt() ){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] price = new int[n];
            String[] list = new String[m];
            for( int i = 0 ; i < n ; i++){
                price[i] = in.nextInt();
            }
            in.nextLine();
            for( int i = 0 ; i < m ;i++){
                list[i] = in.nextLine();
            }
            Arrays.sort( price );
            Arrays.sort( list );
            List<Integer> count = new ArrayList<>();
            if(list.length == 1){
                count.add(1);
            }
            else{
                String fore = list[0];
                int num = 1;
                for( int i = 1 ;i < m ; i++){
                    if( list[i].equals(fore) ){
                        num++;
                    }
                    else{
                        count.add(num);
                        num = 1;
                        fore =list[i];
                    }
                    if( i == m-1){  /* ע�⣬����߽�������ÿ�ζ�Ҫ�ж��Ƿ񵽴����һ���������Ƴ�ѭ����û�˴����� */
                        count.add(num);
                    }
                }
            }
            Collections.sort(count, Collections.reverseOrder());
            int max = 0;
            int min = 0;
            int i = 0;
            for(int c : count){
                for( int j = 0 ; j< c ;j++){
                    max += price[price.length -1-i];
                    min += price[i];
                }
                i++;
            }
            System.out.println(min + " " + max );
        }
    }
}
