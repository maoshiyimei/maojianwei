package com.maji.maojianwei.leetcode.tempWorkspace;

/**
 * Class: N�����У���һ�����г�����Ȼ������ȫ�����У���̾��룬 N��
 * ���û��ݷ����м�����ж�����Ѿ��������е���̾�������������
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 20:40
 */
public class BackTrack_4_TSP {
    
    private static int N = 4 ;
    private static int[][] distance = new int[N][N];
    private static int[] path = new int[N];
    private static int[] bestPath = new int[N];
    private static int accDistance = 0;
    private static int bestDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        initCities();
        printCities();
        for(int i =0;i<N;i++) {//��ʼ�����ܹؼ����൱����������У�Ȼ����ݻ��ڴˣ���������
            path[i]=i;
            bestPath[i] =i;
        }
        tsp(1);//�ӵ�һ�����г���, ���ҵڶ�������
        System.out.println("shortest distance : "+ bestDistance);
        for(int i = 0; i < N; i++) {
            System.out.printf("%1d%s", bestPath[i]+1,"  -> ");
        }
        System.out.printf("%1d",1);
        System.out.println();
    }
    public static void tsp(int k){
        if(k == N){
            if( distance[path[k-1]][0] + accDistance < bestDistance ) {//�������ص���ʼ�ص�
                bestDistance = distance[ path[k-1] ][0] + accDistance;
                for(int i =0; i < N; i++) {
                    bestPath[i] = path[i];
                }
            }
        }
        else {
            for(int i = k; i < N ; i++) {
                if(distance[path[k-1]][path[i]] + accDistance <  bestDistance) {
                   int temp = path[k];
                   path[k]= path[i];
                   path[i] = temp;
                   accDistance += distance[ path[k-1] ][ path[k] ];

                    print();
                    tsp(k+1);

                    accDistance -= distance[ path[k-1] ][ path[k] ];
                    temp = path[k];
                    path[k]= path[i];
                    path[i] = temp;


                }

            }

        }

    }
    public static void print() {
        System.out.print("[");
        for(int i =0;i<N;i++) {
            System.out.print(path[i]+" ");
        }
        System.out.println("], accDistance =("+accDistance+"), bestDistance =("+bestDistance+")");
    }
    public static void initCities() {//��ʼ�����룬�Գƾ���
        for(int i =0; i<N; i++) {
            for(int j =i+1; j<N;j++){
                distance[i][j] = (int)(Math.random()*10+1);
                distance[j][i] = distance[i][j];
            }
        }
    }
    public static void printCities() {//��ʾ�������
        System.out.printf("%4s", "|");
        for(int i =0;i<N;i++) {
            System.out.printf("%4d", i+1);
        }
        System.out.println();
        for(int i =0;i<N+1;i++) {
            System.out.printf("%4s","----");
        }
        System.out.println();
        for(int i =0;i<N;i++) {
            System.out.printf("%3d%c",i+1,'|');
            for(int j =0;j<N;j++) {
                System.out.printf("%4d", distance[i][j]);
            }
            System.out.println();
            for(int k =0;k<N+1;k++) {
                System.out.printf("%4s","----");
            }
            System.out.println();

        }
    }

}
