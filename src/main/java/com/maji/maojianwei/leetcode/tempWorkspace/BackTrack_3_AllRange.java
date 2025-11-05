package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/20 , 21:44
 */
public class BackTrack_3_AllRange {

    public static void main(String[] args){
        int[] data = {1,2,3,4};
        getAllPermutaion( data, 4);
    }
    /* ���ݷ�ʵ��ȫ���У� ʱ�临�Ӷ�Ϊ N! �Ѿ������ŵĽⷨ */
    public static void getAllPermutaion(int[] data, int n ){
        if( n == 1){
            for(int i= 0 ;i< data.length;i++){
                System.out.print( data[i]+" ");
            }
            System.out.println();


        }
        else{
            for( int i = 0 ; i< n; i++){//ȫ���еĹؼ����滻��һ����
                int temp = data[n-1];
                data[n-1] = data[i];
                data[i] = temp;

                getAllPermutaion(data, n-1);

                temp = data[n-1];
                data[n-1] = data[i];
                data[i] = temp;
            }
        }
    }


}
